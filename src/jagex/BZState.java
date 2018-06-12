package jagex;

final class BZState {
	protected static final int IO_BUF_SIZE = 4096;
	protected static final int MTFL_SIZE = 16;
	protected static final int MAX_SYMBOLS = 258;
	protected static final int field_213 = 23;
	protected static final int field_215 = 1;
	protected static final int MAX_GROUPS = 6;
	protected static final int GROUP_SIZE = 50;
	protected static final int field_218 = 4;
	protected static final int field_219 = 18002;

	BZState() {
        unzftab = new int[256];
        cftab = new int[257];
        in_use = new boolean[256];
        in_use_16 = new boolean[MTFL_SIZE];
        set_to_unseq = new byte[256];
        mtfa = new byte[IO_BUF_SIZE];
        mtfbase = new int[MTFL_SIZE];
        selector = new byte[18002];
        selector_mtf = new byte[18002];
        len = new byte[MAX_GROUPS][MAX_SYMBOLS];
        limit = new int[MAX_GROUPS][MAX_SYMBOLS];
        base = new int[MAX_GROUPS][MAX_SYMBOLS];
        perm = new int[MAX_GROUPS][MAX_SYMBOLS];
        min_lens = new int[MAX_GROUPS];
    }

    byte input[];
    int next_in;
    int avail_in;
    int total_in_lo32;
    int total_in_hi32;
    byte output[];
    int avail_out;
    int decompressed_size;
    int total_out_lo32;
    int total_out_hi32;
    byte state_out_ch;
    int state_out_len;
    boolean block_randomised;
    int bs_buff;
    int bs_live;
    int blocksize100k;
    int block_no;
    int orig_ptr;
    int tpos;
    int k0;
    int unzftab[];
    int nblock_used;
    int cftab[];
    int tt[];
    int n_in_use;
    boolean in_use[];
    boolean in_use_16[];
    byte set_to_unseq[];
    byte mtfa[];
    int mtfbase[];
    byte selector[];
    byte selector_mtf[];
    byte len[][];
    int limit[][];
    int base[][];
    int perm[][];
    int min_lens[];
    int save_nblock;
}
