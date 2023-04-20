package Lexer;
import Errors.LexerException;
import Parser.sym;
import Compiler.*;


public class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;

private java_cup.runtime.Symbol tok(int k, Object value, String valuestr) {
  //System.out.println("Token: " + valuestr);
  return new java_cup.runtime.Symbol(k, yyline, 0, value); 
}
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NOT_ACCEPT,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NOT_ACCEPT,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NOT_ACCEPT,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NOT_ACCEPT,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NOT_ACCEPT,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NOT_ACCEPT,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NO_ANCHOR,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NO_ANCHOR,
		/* 126 */ YY_NO_ANCHOR,
		/* 127 */ YY_NO_ANCHOR,
		/* 128 */ YY_NO_ANCHOR,
		/* 129 */ YY_NO_ANCHOR,
		/* 130 */ YY_NO_ANCHOR,
		/* 131 */ YY_NO_ANCHOR,
		/* 132 */ YY_NO_ANCHOR,
		/* 133 */ YY_NO_ANCHOR,
		/* 134 */ YY_NO_ANCHOR,
		/* 135 */ YY_NO_ANCHOR,
		/* 136 */ YY_NO_ANCHOR,
		/* 137 */ YY_NO_ANCHOR,
		/* 138 */ YY_NO_ANCHOR,
		/* 139 */ YY_NO_ANCHOR,
		/* 140 */ YY_NO_ANCHOR,
		/* 141 */ YY_NO_ANCHOR,
		/* 142 */ YY_NO_ANCHOR,
		/* 143 */ YY_NO_ANCHOR,
		/* 144 */ YY_NO_ANCHOR,
		/* 145 */ YY_NO_ANCHOR,
		/* 146 */ YY_NO_ANCHOR,
		/* 147 */ YY_NO_ANCHOR,
		/* 148 */ YY_NO_ANCHOR,
		/* 149 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"50:9,49:2,50,48,49,50:18,49,50:7,35,36,34,32,37,38,44,33,4,43,3,5,43:6,28,2" +
"7,30,29,31,50:2,46:4,47,2,46:2,21,46:6,1,46,22,46:8,50:6,18,26,24,14,10,7,4" +
"0,9,6,46,42,12,46,11,17,16,46,19,13,8,39,23,15,25,41,20,50,45,50:3,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,150,
"0,1,2,3,1,4,1:11,5,6:3,7,1,8,9,10,6:6,11,6:11,12,6:11,13,14,15,9,10,16,1,17" +
",18,19,20,11,21,12,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40" +
",41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65" +
",66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,6,88,89," +
"90,91,92,93,94,6,95,96,97,98,99")[0];

	private int yy_nxt[][] = unpackFromString(100,51,
"1,2,144,3:3,57,133,120,144,97,98,144,121,61,134,64,66,99,100,144,146,147,12" +
"2,148,144,123,4,5,6,7,8,9,10,11,12,13,14,15,144,124,149,144,3,58,62,144:2,1" +
"6,59,62,-1:52,144,135,136:3,144:21,-1:12,144:4,136,-1:2,144:2,-1:6,3:3,-1:4" +
",56,-1:32,3,17,56,-1,56,-1:32,22,-1:24,23:3,-1:4,63,-1:32,23,-1,63,-1,63,-1" +
":4,144:2,136:3,144:21,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:12,12" +
"8,144:8,-1:12,144:4,136,-1:2,144:2,-1:6,23:3,-1:4,65,-1:32,23,-1,65,-1,65,-" +
"1:52,24,-1:4,25:3,-1:37,25,-1:10,32:3,-1:37,32,-1:10,44:3,-1:37,44,-1:10,25" +
":3,-1:26,60,-1:5,60,-1:4,25,-1:8,144:2,136:3,144,18,144:3,68,144:15,-1:12,1" +
"44:4,136,-1:2,144:2,-1:6,23:3,-1:37,23,-1:8,144:2,136:3,144:11,19,144:9,-1:" +
"12,144:4,136,-1:2,144:2,-1:6,32:3,-1:26,67,-1:5,67,-1:4,32,-1:8,144:2,136:3" +
",20,144:5,106,144:14,-1:12,144:4,136,-1:2,144:2,-1:6,44:3,-1:26,69,-1:5,69," +
"-1:4,44,-1:8,144:2,136:3,144:13,21,144:7,-1:12,144:4,136,-1:2,144:2,-1:4,14" +
"4:2,136:3,144:2,26,144:18,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:8" +
",27,144:12,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:10,28,144:10,-1:" +
"12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:2,29,144:18,-1:12,144:4,136,-1" +
":2,144:2,-1:4,144:2,136:3,144:8,30,144:12,-1:12,144:4,136,-1:2,144:2,-1:4,1" +
"44:2,136:3,144:8,31,144:3,81,144:8,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,13" +
"6:3,144:5,33,144:15,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:4,34,14" +
"4:16,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:4,35,144:16,-1:12,144:" +
"4,136,-1:2,144:2,-1:4,144:2,136:3,144:4,36,144:16,-1:12,144:4,136,-1:2,144:" +
"2,-1:4,144:2,136:3,144:11,37,144:9,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,13" +
"6:3,144:2,38,144:18,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:6,39,14" +
"4:14,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:7,40,144:13,-1:12,144:" +
"4,136,-1:2,144:2,-1:4,144:2,136:3,144:4,41,144:16,-1:12,144:4,136,-1:2,144:" +
"2,-1:4,144:2,136:3,144:6,42,144:14,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,13" +
"6:3,144:4,90,144:16,-1:12,144:2,43,144,136,-1:2,144:2,-1:4,144:2,136:3,144:" +
"4,45,144:16,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:4,46,144:16,-1:" +
"12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:4,47,144:16,-1:12,144:4,136,-1" +
":2,144:2,-1:4,144:2,136:3,144:21,-1:12,144:3,48,136,-1:2,144:2,-1:4,144:2,1" +
"36:3,144:5,49,144:15,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:2,50,144:21," +
"-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:4,51,144:16,-1:12,144:4,136" +
",-1:2,144:2,-1:4,144:2,136:3,144:11,52,144:9,-1:12,144:4,136,-1:2,144:2,-1:" +
"4,144:2,136:3,144:9,53,144:11,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,1" +
"44:6,54,144:14,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:2,55,144:18," +
"-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:5,70,103,144:12,71,144,-1:1" +
"2,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:11,72,144:9,-1:12,144:4,136,-1:" +
"2,144:2,-1:4,144:2,136:3,144:5,73,144:15,-1:12,144:4,136,-1:2,144:2,-1:4,14" +
"4:2,136:3,144:4,74,144:16,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:4" +
",75,144:16,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:21,-1:12,76,144:" +
"3,136,-1:2,144:2,-1:4,144:2,136:3,144:7,77,144:13,-1:12,144:4,136,-1:2,144:" +
"2,-1:4,144:2,136:3,144:14,78,144:6,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,13" +
"6:3,144:5,79,144:15,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:11,80,1" +
"44:9,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:13,82,144:7,-1:12,144:" +
"4,136,-1:2,144:2,-1:4,144:2,136:3,144:12,113,144:8,-1:12,83,144:3,136,-1:2," +
"144:2,-1:4,144:2,136:3,144:11,84,144:9,-1:12,144:4,136,-1:2,144:2,-1:4,144:" +
"2,136:3,144:4,85,144:16,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:7,8" +
"6,144:13,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:2,87,144:3,88,144:" +
"14,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:18,89,144:2,-1:12,144:4," +
"136,-1:2,144:2,-1:4,144:2,91,136:2,144:21,-1:12,144:4,136,-1:2,144:2,-1:4,1" +
"44:2,136:3,144:21,-1:12,144,92,144:2,136,-1:2,144:2,-1:4,144:2,136:3,144:5," +
"93,144:15,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:11,94,144:9,-1:12" +
",144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:12,95,144:8,-1:12,144:4,136,-1:2" +
",144:2,-1:4,144:2,136:3,144:5,96,144:15,-1:12,144:4,136,-1:2,144:2,-1:4,144" +
":2,136:3,144:3,101,144:9,102,144:7,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,13" +
"6:3,104,144:3,105,144:16,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:12" +
",107,144:8,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:6,108,144:4,109," +
"144:9,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:13,110,144:7,-1:12,14" +
"4:4,136,-1:2,144:2,-1:4,144:2,136:3,144:6,111,144:14,-1:12,144:4,136,-1:2,1" +
"44:2,-1:4,144:2,136:3,112,144:20,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136," +
"114,136,144:21,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:5,115,144:15" +
",-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:4,116,144:16,-1:12,144:4,1" +
"36,-1:2,144:2,-1:4,144:2,136:3,144:6,117,144:14,-1:12,144:4,136,-1:2,144:2," +
"-1:4,144:2,136:3,144:4,118,144:16,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136" +
":3,144:15,119,144:5,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:12,125," +
"144:8,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:3,126,144:17,-1:12,14" +
"4:4,136,-1:2,144:2,-1:4,144:2,127,136:2,144:21,-1:12,144:4,136,-1:2,144:2,-" +
"1:4,144:2,136:3,144:2,145,144:18,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:" +
"3,144:12,141,144:8,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:7,129,14" +
"4:13,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:6,130,144:14,-1:12,144" +
":4,136,-1:2,144:2,-1:4,144:2,136:3,144:6,143,144:14,-1:12,144:4,136,-1:2,14" +
"4:2,-1:4,144:2,136:3,144:16,131,144:4,-1:12,144:4,136,-1:2,144:2,-1:4,144:2" +
",132,136:2,144:21,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,142,136:2,144:21,-1" +
":12,144:4,136,-1:2,144:2,-1:4,144:2,136:3,144:5,137,144:15,-1:12,144:4,136," +
"-1:2,144:2,-1:4,144:2,136:3,144:4,138,144:16,-1:12,144:4,136,-1:2,144:2,-1:" +
"4,144:2,136:3,144:11,139,144:9,-1:12,144:4,136,-1:2,144:2,-1:4,144:2,136:3," +
"144:4,140,144:16,-1:12,144:4,136,-1:2,144:2,-1:3");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException, 
LexerException

		{
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

{return tok(sym.EOF, null,"EOF"); }
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -3:
						break;
					case 3:
						{return tok(sym.CENT, new Integer(yytext()), "CENT"); }
					case -4:
						break;
					case 4:
						{return tok(sym.PC, null, "PC"); }
					case -5:
						break;
					case 5:
						{throw new LexerException("Illegal character in line " + yyline);}
					case -6:
						break;
					case 6:
						{return tok(sym.IGUALQUE, null, "IGUALQUE"); }
					case -7:
						break;
					case 7:
						{return tok(sym.MENORQUE, null, "MENORQUE"); }
					case -8:
						break;
					case 8:
						{return tok(sym.MAYORQUE, null, "MAYORQUE"); }
					case -9:
						break;
					case 9:
						{return tok(sym.MAS, null, "MAS"); }
					case -10:
						break;
					case 10:
						{return tok(sym.DIV, null, "DIV"); }
					case -11:
						break;
					case 11:
						{return tok(sym.POR, null, "POR"); }
					case -12:
						break;
					case 12:
						{return tok(sym.PAREN, null, "PAREN"); }
					case -13:
						break;
					case 13:
						{return tok(sym.TESIS, null, "TESIS"); }
					case -14:
						break;
					case 14:
						{return tok(sym.COMA, null, "COMA"); }
					case -15:
						break;
					case 15:
						{return tok(sym.MENOS, null, "MENOS"); }
					case -16:
						break;
					case 16:
						{ }
					case -17:
						break;
					case 17:
						{return tok(sym.CREAL, new Double(yytext()), "CREAL"); }
					case -18:
						break;
					case 18:
						{return tok(sym.IF, null, "IF"); }
					case -19:
						break;
					case 19:
						{return tok(sym.DO, null, "DO"); }
					case -20:
						break;
					case 20:
						{return tok(sym.PI, Type.REAL, "PI"); }
					case -21:
						break;
					case 21:
						{return tok(sym.OR, null, "OR"); }
					case -22:
						break;
					case 22:
						{return tok(sym.ASOP, null, "ASOP"); }
					case -23:
						break;
					case 23:
						{return tok(sym.CREAL, new Double(yytext()), "CREAL"); }
					case -24:
						break;
					case 24:
						{ }
					case -25:
						break;
					case 25:
						{return tok(sym.CREAL, new Double(yytext()), "CREAL"); }
					case -26:
						break;
					case 26:
						{return tok(sym.TIPO, Type.INT, "TIPO"); }
					case -27:
						break;
					case 27:
						{return tok(sym.END, null, "END"); }
					case -28:
						break;
					case 28:
						{return tok(sym.EXPONENCIAL, null, "EXPONENCIAL");}
					case -29:
						break;
					case 29:
						{return tok(sym.NOT, null, "NOT"); }
					case -30:
						break;
					case 30:
						{return tok(sym.AND, null, "AND"); }
					case -31:
						break;
					case 31:
						{return tok(sym.COLOR, 3, "COLOR"); }
					case -32:
						break;
					case 32:
						{return tok(sym.CREAL, new Double(yytext()), "CREAL"); }
					case -33:
						break;
					case 33:
						{return tok(sym.THEN, null, "THEN"); }
					case -34:
						break;
					case 34:
						{return tok(sym.CLOG, new Boolean(true), "TRUE"); }
					case -35:
						break;
					case 35:
						{return tok(sym.ELSE, null, "ELSE"); }
					case -36:
						break;
					case 36:
						{return tok(sym.SIZE, null, "SIZE"); }
					case -37:
						break;
					case 37:
						{return tok(sym.SENO, null, "SENO");}
					case -38:
						break;
					case 38:
						{return tok(sym.PLOT, null, "PLOT"); }
					case -39:
						break;
					case 39:
						{return tok(sym.TIPO, Type.REAL, "TIPO"); }
					case -40:
						break;
					case 40:
						{return tok(sym.VARS, null, "VARS");}
					case -41:
						break;
					case 41:
						{return tok(sym.COLOR, 5, "COLOR"); }
					case -42:
						break;
					case 42:
						{return tok(sym.TIPO, Type.BOOL, "TIPO"); }
					case -43:
						break;
					case 43:
						{return tok(sym.COLOR, 1, "COLOR"); }
					case -44:
						break;
					case 44:
						{return tok(sym.CREAL, new Double(yytext()), "CREAL"); }
					case -45:
						break;
					case 45:
						{return tok(sym.CLOG, new Boolean(false), "FALSE"); }
					case -46:
						break;
					case 46:
						{return tok(sym.COLOR, 0, "COLOR"); }
					case -47:
						break;
					case 47:
						{return tok(sym.WHILE, null, "WHILE"); }
					case -48:
						break;
					case 48:
						{return tok(sym.COLOR, 2, "COLOR"); }
					case -49:
						break;
					case 49:
						{return tok(sym.COLOR, 4, "COLOR"); }
					case -50:
						break;
					case 50:
						{return tok(sym.PROG, null, "PROG"); }
					case -51:
						break;
					case 51:
						{return tok(sym.COLOR, 7, "COLOR"); }
					case -52:
						break;
					case 52:
						{return tok(sym.COSENO, null, "COSENO");}
					case -53:
						break;
					case 53:
						{return tok(sym.COLOR, 6, "COLOR"); }
					case -54:
						break;
					case 54:
						{return tok(sym.INT2REAL, null, "INT2REAL"); }
					case -55:
						break;
					case 55:
						{return tok(sym.REAL2INT, null, "REAL2INT"); }
					case -56:
						break;
					case 57:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -57:
						break;
					case 58:
						{throw new LexerException("Illegal character in line " + yyline);}
					case -58:
						break;
					case 59:
						{ }
					case -59:
						break;
					case 61:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -60:
						break;
					case 62:
						{throw new LexerException("Illegal character in line " + yyline);}
					case -61:
						break;
					case 64:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -62:
						break;
					case 66:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -63:
						break;
					case 68:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -64:
						break;
					case 70:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -65:
						break;
					case 71:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -66:
						break;
					case 72:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -67:
						break;
					case 73:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -68:
						break;
					case 74:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -69:
						break;
					case 75:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -70:
						break;
					case 76:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -71:
						break;
					case 77:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -72:
						break;
					case 78:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -73:
						break;
					case 79:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -74:
						break;
					case 80:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -75:
						break;
					case 81:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -76:
						break;
					case 82:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -77:
						break;
					case 83:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -78:
						break;
					case 84:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -79:
						break;
					case 85:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -80:
						break;
					case 86:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -81:
						break;
					case 87:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -82:
						break;
					case 88:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -83:
						break;
					case 89:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -84:
						break;
					case 90:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -85:
						break;
					case 91:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -86:
						break;
					case 92:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -87:
						break;
					case 93:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -88:
						break;
					case 94:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -89:
						break;
					case 95:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -90:
						break;
					case 96:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -91:
						break;
					case 97:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -92:
						break;
					case 98:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -93:
						break;
					case 99:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -94:
						break;
					case 100:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -95:
						break;
					case 101:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -96:
						break;
					case 102:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -97:
						break;
					case 103:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -98:
						break;
					case 104:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -99:
						break;
					case 105:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -100:
						break;
					case 106:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -101:
						break;
					case 107:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -102:
						break;
					case 108:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -103:
						break;
					case 109:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -104:
						break;
					case 110:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -105:
						break;
					case 111:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -106:
						break;
					case 112:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -107:
						break;
					case 113:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -108:
						break;
					case 114:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -109:
						break;
					case 115:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -110:
						break;
					case 116:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -111:
						break;
					case 117:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -112:
						break;
					case 118:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -113:
						break;
					case 119:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -114:
						break;
					case 120:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -115:
						break;
					case 121:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -116:
						break;
					case 122:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -117:
						break;
					case 123:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -118:
						break;
					case 124:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -119:
						break;
					case 125:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -120:
						break;
					case 126:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -121:
						break;
					case 127:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -122:
						break;
					case 128:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -123:
						break;
					case 129:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -124:
						break;
					case 130:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -125:
						break;
					case 131:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -126:
						break;
					case 132:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -127:
						break;
					case 133:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -128:
						break;
					case 134:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -129:
						break;
					case 135:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -130:
						break;
					case 136:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -131:
						break;
					case 137:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -132:
						break;
					case 138:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -133:
						break;
					case 139:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -134:
						break;
					case 140:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -135:
						break;
					case 141:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -136:
						break;
					case 142:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -137:
						break;
					case 143:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -138:
						break;
					case 144:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -139:
						break;
					case 145:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -140:
						break;
					case 146:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -141:
						break;
					case 147:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -142:
						break;
					case 148:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -143:
						break;
					case 149:
						{return tok(sym.IDENT, yytext(), "IDENT"); }
					case -144:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
