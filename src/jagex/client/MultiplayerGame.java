package jagex.client;

import jagex.DataUtil;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.math.BigInteger;

@SuppressWarnings("serial")
public abstract class MultiplayerGame extends Game {
	public static String[] response_status_text = new String[50];
	public static int version = 1;
	public static int time_out;
	
	static {
		response_status_text[0] = "You must enter both a username";
		response_status_text[1] = "and a password - Please try again";
		response_status_text[2] = "Connection lost! Please wait...";
		response_status_text[3] = "Attempting to re-establish";
		response_status_text[4] = "That username is already in use.";
		response_status_text[5] = "Wait 60 seconds then retry";
		response_status_text[6] = "Please wait...";
		response_status_text[7] = "Connecting to server";
		response_status_text[8] = "Sorry! The server is currently full.";
		response_status_text[9] = "Please try again later";
		response_status_text[10] = "Invalid username or password.";
		response_status_text[11] = "Try again, or create a new account";
		response_status_text[12] = "Sorry! Unable to connect to server.";
		response_status_text[13] = "Check your internet settings";
		response_status_text[14] = "Username already taken.";
		response_status_text[15] = "Please choose another username";
		response_status_text[16] = "The client has been updated.";
		response_status_text[17] = "Please reload this page";
		response_status_text[18] = "You may only use 1 character at once.";
		response_status_text[19] = "Your ip-address is already in use";
		response_status_text[20] = "Login attempts exceeded!";
		response_status_text[21] = "Please try again in 5 minutes";
		response_status_text[22] = "Account has been temporarily disabled";
		response_status_text[23] = "for cheating or abuse";
		response_status_text[24] = "Account has been permanently disabled";
		response_status_text[25] = "for cheating or abuse";
		response_status_text[26] = "You need a members account";
		response_status_text[27] = "to login to this server";
		response_status_text[28] = "Please login to a members server";
		response_status_text[29] = "to access member-only features";
	}
	
	public String host = "127.0.0.1";
	public int server_port = 43594;
	
	String username = "";
	String password = "";
	
	public Connection conn;
	byte[] frame_buf = new byte[5000];
	
	int attempts_left;
	long last_tick;
	
	public int friend_cnt;
	public long[] friend_hash = new long[100];
	public int[] friend_world = new int[100];
	
	public int ignore_cnt;
	public long[] ignore_hash = new long[50];
	
	public int block_public;
	public int block_private;
	public int block_trades;
	public int block_duels;
	
	public BigInteger exp;
	public BigInteger mod;
	
	public int sess_id;
	public int login_delay;
	
	public abstract void status_text(String first, String second);

	public abstract void reset_game_state();

	public abstract void reset_login_state();

	public abstract void reset_register_state();

	public abstract void logout_disabled();

	public abstract void handle_frame(int id, int len, byte[] buf);
	
	public abstract void push_message(String message);

	public void set_rsa_key(BigInteger exponent, BigInteger modulus) {
		exp = exponent;
		mod = modulus;
	}

	public int seed() {
		try {
			String ranseed = getParameter("ranseed");
			String trimmed = ranseed.substring(0, 10);
			
			int parsed = Integer.parseInt(trimmed);
			
			if (parsed == 987654321) {
				byte[] buf = new byte[4];
				DataUtil.read("uid.dat", buf, 4);
				parsed = DataUtil.int_get(buf, 0);
			}

			return parsed;
		} catch (Exception error) {
			return 0;
		}
	}

	public void login(String user, String pass, boolean reconnect) {
		if (login_delay > 0) {
			status_text(response_status_text[6], response_status_text[7]);

			try {
				Thread.sleep(2000L);
			} catch (Exception error) { }

			status_text(response_status_text[8], response_status_text[9]);
		} else {
			try {
				username = user;
				user = DataUtil.filter_str(user, 20);
				password = pass;
				pass = DataUtil.filter_str(pass, 20);
				
				if (user.trim().length() == 0) {
					status_text(response_status_text[0], response_status_text[1]);
				} else {
					if (reconnect) {
						status_alert(response_status_text[2], response_status_text[3]);
					} else {
						status_text(response_status_text[6], response_status_text[7]);
					}

					if (is_applet()) {
						conn = new Connection(host, this, server_port);
					} else {
						conn = new Connection(host, (Applet) null, server_port);
					}

					conn.time_out = time_out;
					sess_id = conn.read_int();

					System.out.println("Session id: " + sess_id);
					
					if (reconnect) {
						conn.enter(19);
					} else {
						conn.enter(0);
					}

					conn.short_put(version);
					conn.long_put(DataUtil.encode_name(user));
					conn.enc_cred_put(pass, sess_id, exp, mod);
					conn.int_put(seed());
					conn.send();
					
					conn.read();
					int response = conn.read();
					
					System.out.println("Login response: " + response);
					
					if (response == 0) {
						attempts_left = 0;
						reset_game_state();
					} else if (response == 1) {
						attempts_left = 0;
					} else if (reconnect) {
						user = "";
						pass = "";
						reset_login_state();
					} else if (response == 3) {
						status_text(response_status_text[10], response_status_text[11]);
					} else if (response == 4) {
						status_text(response_status_text[4], response_status_text[5]);
					} else if (response == 5) {
						status_text(response_status_text[16], response_status_text[17]);
					} else if (response == 6) {
						status_text(response_status_text[18], response_status_text[19]);
					} else if (response == 7) {
						status_text(response_status_text[20], response_status_text[21]);
					} else if (response == 11) {
						status_text(response_status_text[22], response_status_text[23]);
					} else if (response == 12) {
						status_text(response_status_text[24], response_status_text[25]);
					} else if (response == 13) {
						status_text(response_status_text[14], response_status_text[15]);
					} else if (response == 14) {
						status_text(response_status_text[8], response_status_text[9]);
						login_delay = 1500;
					} else if (response == 15) {
						status_text(response_status_text[26], response_status_text[27]);
					} else if (response == 16) {
						status_text(response_status_text[28], response_status_text[29]);
					} else {
						status_text(response_status_text[12], response_status_text[13]);
					}
				}
			} catch (Exception ex) {
				System.out.println(String.valueOf(ex));
				
				if (attempts_left > 0) {
					try {
						Thread.sleep(5000L);
					} catch (Exception error) { }

					attempts_left -= 1;
					login(username, password, reconnect);
				}

				if (reconnect) {
					username = "";
					password = "";
					reset_login_state();
				} else {
					status_text(response_status_text[12], response_status_text[13]);
				}

			}
		}
	}

	public void register(String user, String pass) {
		if (login_delay > 0) {
			status_text(response_status_text[6], response_status_text[7]);

			try {
				Thread.sleep(2000L);
			} catch (Exception error) { }

			status_text(response_status_text[8], response_status_text[9]);
		} else {
			try {
				user = DataUtil.filter_str(user, 20);
				pass = DataUtil.filter_str(pass, 20);

				status_text(response_status_text[6], response_status_text[7]);
				
				if (is_applet()) {
					conn = new Connection(host, this, server_port);
				} else {
					conn = new Connection(host, (Applet) null, server_port);
				}

				sess_id = conn.read_int();
				System.out.println("Session id: " + sess_id);
				
				conn.enter(2);
				conn.short_put(version);
				conn.long_put(DataUtil.encode_name(user));
				conn.enc_cred_put(pass, sess_id, exp, mod);
				conn.int_put(seed());
				conn.send();
				
				conn.read(); // why?
				int response = conn.read();
				conn.close();
				
				System.out.println("Newplayer response: " + response);
				
				if (response == 2) {
					reset_register_state();
				} else if (response == 3) {
					status_text(response_status_text[14], response_status_text[15]);
				} else if (response == 4) {
					status_text(response_status_text[4], response_status_text[5]);
				} else if (response == 5) {
					status_text(response_status_text[16], response_status_text[17]);
				} else if (response == 6) {
					status_text(response_status_text[18], response_status_text[19]);
				} else if (response == 7) {
					status_text(response_status_text[20], response_status_text[21]);
				} else if (response == 11) {
					status_text(response_status_text[22], response_status_text[23]);
				} else if (response == 12) {
					status_text(response_status_text[24], response_status_text[25]);
				} else if (response == 13) {
					status_text(response_status_text[14], response_status_text[15]);
				} else if (response == 14) {
					status_text(response_status_text[8], response_status_text[9]);
					login_delay = 1500;
				} else if (response == 15) {
					status_text(response_status_text[26], response_status_text[27]);
				} else if (response == 16) {
					status_text(response_status_text[28], response_status_text[29]);
				} else {
					status_text(response_status_text[12], response_status_text[13]);
				}
			} catch (Exception error) {
				System.out.println(String.valueOf(error));
				status_text(response_status_text[12], response_status_text[13]);
			}
		}
	}
	
	public void status_alert(String first, String second) {
		Graphics gfx = getGraphics();
		Font font = new Font("Helvetica", Font.BOLD, 15);
		
		int w = width();
		int h = height();
		
		gfx.setColor(Color.black);
		gfx.fillRect(w / 2 - 140, h / 2 - 25, 280, 50);
		gfx.setColor(Color.white);
		gfx.drawRect(w / 2 - 140, h / 2 - 25, 280, 50);
		
		text_draw(gfx, first, font, w / 2, h / 2 - 10);
		text_draw(gfx, second, font, w / 2, h / 2 + 10);
	}
	
	public void conn_close() {
		if (conn != null) {
			try {
				conn.enter(1);
				conn.send();
			} catch (IOException error) { }
		}

		username = "";
		password = "";
		reset_login_state();
	}

	public void conn_dropped() {
		System.out.println("Lost connection");
		attempts_left = 10;
		login(username, password, true);
	}

	public void conn_check() {
		long now = System.currentTimeMillis();
		
		if (conn.in_frame()) {
			last_tick = now;
		}

		if (now - last_tick > 5000L) {
			last_tick = now;
			conn.enter(5);
			conn.exit();
		}

		try {
			conn.flush(20);
		} catch (IOException error) {
			conn_dropped();
			return;
		}

		int len = conn.frame_read(frame_buf);
			
		if (len > 0) {
			handle_frame(frame_buf[0] & 255, len);
		}
	}

	public void handle_frame(int id, int len) {
		if (id == 8) {
			String message = new String(frame_buf, 1, len - 1);
			push_message(message);
		} else if (id == 9) {
			conn_close();
		} else if (id == 10) {
			logout_disabled();
		} else if (id == 23) {
			friend_cnt = DataUtil.unsign(frame_buf[1]);

			for (int i = 0; i < friend_cnt; ++i) {
				friend_hash[i] = DataUtil.long_get(frame_buf, 2 + i * 9);
				friend_world[i] = DataUtil.unsign(frame_buf[10 + i * 9]);
			}

			friend_sort();
		} else if (id == 24) {
			long hash = DataUtil.long_get(frame_buf, 1);
			int world = frame_buf[9] & 255;

			for (int i = 0; i < friend_cnt; ++i) {
				if (friend_hash[i] == hash) {
					if (friend_world[i] == 0 && world != 0) {
						push_message("@pri@" + DataUtil.decode_name(hash) + " has logged in");
					}

					if (friend_world[i] != 0 && world == 0) {
						push_message("@pri@" + DataUtil.decode_name(hash) + " has logged out");
					}

					friend_world[i] = world;
					friend_sort();
					return;
				}
			}

			friend_hash[friend_cnt] = hash;
			friend_world[friend_cnt] = world;
			friend_cnt += 1;
			
			push_message("@pri@" + DataUtil.decode_name(hash) + " has been added to your friends list");
			friend_sort();
		} else if (id == 26) {
			ignore_cnt = DataUtil.unsign(frame_buf[1]);

			for (int i = 0; i < ignore_cnt; ++i) {
				ignore_hash[i] = DataUtil.long_get(frame_buf, 2 + i * 8);
			}
		} else if (id == 27) {
			block_public = frame_buf[1];
			block_private = frame_buf[2];
			block_trades = frame_buf[3];
			block_duels = frame_buf[4];
		} else if (id == 28) {
			long hash = DataUtil.long_get(frame_buf, 1);
			String message = DataUtil.decode_censor(frame_buf, 9, len - 9, true);
			
			push_message("@pri@" + DataUtil.decode_name(hash) + ": tells you " + message);
		} else {
			handle_frame(id, len, frame_buf);
		}
	}

	public void friend_sort() {
		boolean found = true;

		while (found) {
			found = false;
			
			for (int i = 0; i < friend_cnt - 1; ++i) {
				if (friend_world[i] < friend_world[i + 1]) {
					int world = friend_world[i];
					friend_world[i] = friend_world[i + 1];
					friend_world[i + 1] = world;
					
					long hash = friend_hash[i];
					friend_hash[i] = friend_hash[i + 1];
					friend_hash[i + 1] = hash;
					found = true;
				}
			}
		}
	}

	public void send_cred(String user, String pass) {
		user = DataUtil.filter_str(user, 20);
		pass = DataUtil.filter_str(pass, 20);
		conn.enter(25);
		conn.enc_cred_put(user + pass, sess_id, exp, mod);
		conn.exit();
	}
	
	public void friend_add(String name) {
		conn.enter(26);
		conn.long_put(DataUtil.encode_name(name));
		conn.exit();
	}

	public void friend_remove(long hash) {
		conn.enter(27);
		conn.long_put(hash);
		conn.exit();

		for (int i = 0; i < friend_cnt; ++i) {
			if (friend_hash[i] != hash) {
				continue;
			}
	
			friend_cnt -= 1;

			for (int j = i; j < friend_cnt; j++) {
				friend_hash[j] = friend_hash[j + 1];
				friend_world[j] = friend_world[j + 1];
			}
			
			break;
		}

		push_message("@pri@" + DataUtil.decode_name(hash) + " has been removed from your friends list");
	}

	public void ignore_add(String name) {
		long hash = DataUtil.encode_name(name);

		conn.enter(29);
		conn.long_put(hash);
		conn.exit();

		for (int i = 0; i < ignore_cnt; ++i) {
			if (ignore_hash[i] == hash) {
				return;
			}
		}

		if (ignore_cnt < 50) {
			ignore_hash[ignore_cnt++] = hash;
		}
	}

	public void ignore_remove(long hash) {
		conn.enter(30);
		conn.long_put(hash);
		conn.exit();

		for (int i = 0; i < ignore_cnt; ++i) {
			if (ignore_hash[i] != hash) {
				continue;
			}
			ignore_cnt -= 1;

			for (int j = i; j < ignore_cnt; ++j) {
				ignore_hash[j] = ignore_hash[j + 1];
			}
			return;
		}
	}

	public void send_settings(int block_pub, int block_priv, int block_trade, int block_duel) {
		conn.enter(31);
		conn.byte_put(block_pub);
		conn.byte_put(block_priv);
		conn.byte_put(block_trade);
		conn.byte_put(block_duel);
		conn.exit();
	}

	public void send_message(byte[] msg, int len) {
		conn.enter(3);
		conn.bytes_put(msg, 0, len);
		conn.exit();
	}

	public void send_priv_message(long hash, byte[] msg, int len) {
		conn.enter(28);
		conn.long_put(hash);
		conn.bytes_put(msg, 0, len);
		conn.exit();
	}

	public void send_command(String command) {
		conn.enter(7);
		conn.str_put(command);
		conn.exit();
	}
}
