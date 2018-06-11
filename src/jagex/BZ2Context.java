package jagex;

final class BZ2Context {
	public static int[] d_buf;

	private static final int IO_BUF_SIZE = 4096;
	private static final int field_211 = 16;
	private static final int MAX_SYMBOLS = 258;
	private static final int field_213 = 23;
	private static final int field_215 = 1;
	private static final int MAX_GROUPS = 6;
	private static final int GROUP_SIZE = 50;
	private static final int field_218 = 4;
	private static final int field_219 = 18002;

	int field_214;
	byte[] in_buf;
	int in_buf_pos;
	int in_buf_sz;
	int field_223;
	int field_224;
	byte[] out_buf;
	int field_226;
	int out_buf_sz;
	int field_228;
	int field_229;
	byte field_230;
	int field_231;
	boolean field_232;
	int in_buf_bits;
	int in_buf_bit_cnt;
	int block_sz;
	int field_236;
	int field_237;
	int field_238;
	int field_239;
	int[] crc32_table = new int[256];
	int field_241;
	int[] field_242 = new int[257];
	int[] field_243 = new int[257];
	int field_245;
	boolean[] field_246 = new boolean[256];
	boolean[] field_247 = new boolean[16];
	byte[] field_248 = new byte[256];
	byte[] not_out_buf = new byte[IO_BUF_SIZE];
	int[] field_250 = new int[16];
	byte[] field_251 = new byte[18002];
	byte[] field_252 = new byte[18002];
	byte[][] field_253 = new byte[MAX_GROUPS][MAX_SYMBOLS];
	int[][] field_254 = new int[MAX_GROUPS][MAX_SYMBOLS];
	int[][] field_255 = new int[MAX_GROUPS][MAX_SYMBOLS];
	int[][] field_256 = new int[MAX_GROUPS][MAX_SYMBOLS];
	int[] field_257 = new int[6];
	int field_258;
}
