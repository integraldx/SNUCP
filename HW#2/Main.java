/* Created and written by kipa00.
 * You can freely modify or distribute this code:
 * - without redistributing the modified code
 * - without removing this comment
 * A code judged AC by this code do not guarantee
 * that your code is absolutely correct.
 * USE AT YOUR OWN RISK.
 */

import java.util.Arrays;
import java.util.Random;

public class Main {

	public Random rand = new Random();
	public final boolean is_windows = System.getProperty("os.name").startsWith("Windows");

	public Object[] handler;
	public Object checker;

	public final long time_limit = 2000000000L;
	public final long hard_time_limit = 5000000000L;

	private interface Checkable {
		public Object run(String s) throws Exception;
	}

	private interface HardCheckable {
		public Object run(String u, String v) throws Exception;
	}

	public static void main(String[] args) {
		new Main().start(args);
	}

	public void start(String[] args) {
		boolean all = args.length == 0 || isIn(args, "all");
		boolean canContinue = true;
		printlnColored("LinkedString.class Integrity Check", "\033[4m\033[1;35m%s\033[0m");
		try {
			if (!clarity_check("LinkedString.class")) {
				if (is_windows) {
					System.out.println("This sentence was to be colored and to blink properly.");
					System.out.println("I'm sorry it isn't because you use WINDOWS.");
				}
				return;
			}
		} catch (Exception err) {
			err.printStackTrace();
			System.out.println("How could this happen?");
			return;
		}
		if (all || isIn(args, "toString")) {
			printlnColored("toString - String constructor", "\033[4m\033[1;35m%s\033[0m");
			canContinue = this.check((String s) -> s.length() == 2000 ? "" : s, (String s) -> new LinkedString(s.length() == 2000 ? "" : s).toString());
			printlnColored("toString - char[] constructor", "\033[4m\033[1;35m%s\033[0m");
			this.check(
				(String s) -> s.length() == 2000 ? "" : s,
				(String s) -> new LinkedString(s.length() == 2000 ? new char[0] : s.toCharArray()).toString()
			);
		}
		if (canContinue) {
			if (all || isIn(args, "substring")) {
				printlnColored("substring", "\033[4m\033[1;35m%s\033[0m");
				this.check((String s) -> {
					handler = new Object[] {rand.nextInt(s.length() * 2) - s.length() / 2, rand.nextInt(s.length() * 2) - s.length() / 2};
					return s.substring((Integer)handler[0], (Integer)handler[1]);
				}, (String s) -> {
					LinkedString ls = new LinkedString(s);
					String res = ls.substring((Integer)handler[0], (Integer)handler[1]).toString();
					if (!ls.toString().equals(s)) {
						return "a message; you modified your LinkedString.";
					}
					return res;
				});
			}
			if (all || isIn(args, "concat")) {
				printlnColored("concat", "\033[4m\033[1;35m%s\033[0m");
				this.check((String s) -> {
					if (s.length() <= 4000) {
						return s.concat(null);
					}
					return s;
				}, (String s) -> {
					if (s.length() == 2000) {
						return new LinkedString(s).concat((String)null);
					} else if (s.length() == 4000) {
						return new LinkedString(s).concat((LinkedStringInterface)null);
					}
					int u = rand.nextInt(s.length()), v = rand.nextInt(3);
					LinkedString ls = new LinkedString(s.substring(0, u));
					String res;
					if (v == 0) {
						res = ls.concat(s.substring(u)).toString();
					} else if (v == 1) {
						res = ls.concat(new LinkedString(s.substring(u))).toString();
					} else {
						res = ls.concat(new Kipa(s.substring(u))).toString();
					}
					if (!ls.toString().equals(s.substring(0, u))) {
						return "a message; you modified your LinkedString.";
					}
					return res;
				});
			}
			if (all || isIn(args, "charAt")) {
				printlnColored("charAt", "\033[4m\033[1;35m%s\033[0m");
				this.check((String s) -> {
					handler = new Object[] {rand.nextInt(s.length() * 2) - s.length() / 2};
					if (s.length() == 2000) {
						handler = new Object[] {s.length() - 1};
					} else if (s.length() == 4000) {
						handler = new Object[] {0};
					}
					return s.charAt((Integer)handler[0]);
				}, (String s) -> {
					return new LinkedString(s).charAt((Integer)handler[0]);
				});
			}
			if (all || isIn(args, "indexOf")) {
				printlnColored("indexOf - char", "\033[4m\033[1;35m%s\033[0m");
				this.check((String s) -> {
					if (s.length() % 4000 == 0) {
						handler = new Object[] {"!@#$%^&*()".charAt(rand.nextInt(10))};
					} else {
						handler = new Object[] {makeString(1).charAt(0)};
					}
					return s.indexOf((Character)handler[0]);
				}, (String s) -> {
					return new LinkedString(s).indexOf((Character)handler[0]);
				});
				printlnColored("indexOf - String", "\033[4m\033[1;35m%s\033[0m");
				this.check((String s) -> {
					if (s.length() <= 4000) {
						handler = new Object[] {s.length() <= 2000 ? "" : (String)null};
					} else if (s.length() % 4000 == 0) {
						handler = new Object[] {makeString(1) + "!@#$%^&*()".charAt(rand.nextInt(10))};
					} else {
						int len = rand.nextInt(4) + 1;
						int temp = rand.nextInt(s.length() - len);
						handler = new Object[] {s.substring(temp, temp + len)};
					}
					return s.indexOf((String)handler[0]);
				}, (String s) -> {
					return new LinkedString(s).indexOf((String)handler[0]);
				});
			}
			if (all || isIn(args, "contains")) {
				printlnColored("contains", "\033[4m\033[1;35m%s\033[0m");
				this.check((String s) -> {
					if (s.length() <= 4000) {
						handler = new Object[] {s.length() <= 2000 ? "" : (String)null};
					} else if (s.length() % 4000 == 0) {
						handler = new Object[] {makeString(1) + "!@#$%^&*()".charAt(rand.nextInt(10))};
					} else {
						int len = rand.nextInt(4) + 1;
						int temp = rand.nextInt(s.length() - len);
						handler = new Object[] {s.substring(temp, temp + len)};
					}
					return s.contains((String)handler[0]);
				}, (String s) -> {
					if (s.length() / 4000 % 2 == 0) {
						return new LinkedString(s).contains(new Kipa((String)handler[0]));
					}
					return new LinkedString(s).contains((String)handler[0]);
				});
			}
			if (all || isIn(args, "compareTo")) {
				printlnColored("compareTo / compareToIgnoreCase", "\033[4m\033[1;35m%s\033[0m");
				this.check((String s) -> {
					if (s.length() <= 8000) {
						handler = new Object[] {s, s.length() % 4000 == 0 ? null : "" , s.length() > 4000};
					} else {
						int v = rand.nextInt(4);
						boolean tf = rand.nextInt(2) == 0;
						if (v == 0) {
							handler = new Object[] {s, s, tf};
						} else if (v == 1) {
							handler = new Object[] {s, s.substring(0, rand.nextInt(s.length())), tf};
						} else if (v == 2) {
							handler = new Object[] {s.substring(0, rand.nextInt(s.length())), s, tf};
						} else if (v == 3) {
							int n1 = rand.nextInt(s.length());
							int n2 = rand.nextInt(s.length());
							if (n1 > n2) {
								int t = n1;
								n1 = n2;
								n2 = t;
							}
							handler = new Object[] {s.substring(0, n2), s.substring(0, n1) + s.substring(n2), tf};
						}
					}
					if ((Boolean)handler[2]) {
						handler[1] = ((String)handler[1]).toLowerCase();
						return ((String)handler[0]).compareToIgnoreCase((String)handler[1]);
					}
					return ((String)handler[0]).compareTo((String)handler[1]);
				}, (String s) -> {
					LinkedStringInterface ls = null;
					if (rand.nextInt(2) == 0) {
						ls = new LinkedString((String)handler[1]);
					} else {
						ls = new Kipa((String)handler[1]);
					}
					if ((Boolean)handler[2]) {
						return new LinkedString((String)handler[0]).compareToIgnoreCase(ls);
					}
					return new LinkedString((String)handler[0]).compareTo(ls);
				});
			}
			if (all || isIn(args, "replace")) {
				printlnColored("replace", "\033[4m\033[1;35m%s\033[0m");
				this.check((String s) -> {
					if (rand.nextInt(20) != 0) {
						handler = new Object[] {s.charAt(rand.nextInt(s.length())), '%'};
					} else {
						handler = new Object[] {'%', s.charAt(rand.nextInt(s.length()))};
					}
					return s.replace((Character)handler[0], (Character)handler[1]);
				}, (String s) -> {
					LinkedString ls = new LinkedString(s);
					String res = ls.replace((Character)handler[0], (Character)handler[1]).toString();
					if (!ls.toString().equals(s)) {
						return "a message; you modified your LinkedString.";
					}
					return res;
				});
			}
			if (all || isIn(args, "remove")) {
				printlnColored("remove", "\033[4m\033[1;35m%s\033[0m");
				if (!this.check((String s) -> {
					String once = makeStringDiff(rand.nextInt(4) + 3);
					int v = rand.nextInt(once.length() + 1);
					once = once.substring(0, v) + "!@#$%^&*()".charAt(rand.nextInt(10)) + once.substring(v);
					v = rand.nextInt(once.length() - 1) + 1;
					String twice = once.substring(0, v) + once + once.substring(v);
					int c = s.length() / 1000;
					String temp = s;
					while (c --> 0) {
						v = rand.nextInt(temp.length() + 1);
						temp = temp.substring(0, v) + (rand.nextInt(2) == 0 ? once : twice) + temp.substring(v);
					}
					handler = new Object[] {temp, once};
					return s;
				}, (String s) -> {
					LinkedString ls = new LinkedString((String)handler[0]);
					ls.remove((String)handler[1]);
					return ls.toString();
				}, 10000, 10000L)) {
					System.err.println(handler[0] + " " + handler[1]);
				}
			}
			if (!isIn(args, "nohard")) {
				printlnColored("Hard Test 1 - large indexOf", "\033[4m\033[1;35m%s\033[0m");
				{
					printColored("* Test 1:", "\033[1;34m%s\033[0m");
					hard_check((String u, String v) -> new LinkedString(u).indexOf(v), iter(iter("a", 999) + "b", 999) + iter("a", 1000), iter("a", 1000), 999000);
					printColored("* Test 2:", "\033[1;34m%s\033[0m");
					hard_check((String u, String v) -> new LinkedString(u).indexOf(v), iter("k", 999999) + "p", iter("k", 499999) + "p", 500000);
					printColored("* Test 3:", "\033[1;34m%s\033[0m");
					hard_check((String u, String v) -> new LinkedString(u).indexOf(v), iter("u", 1000000), iter("u", 499999) + "v", -1);
					printColored("* Test 4:", "\033[1;34m%s\033[0m");
					hard_check((String u, String v) -> new LinkedString(u).indexOf(v), iter("I", 500000) + iter("J", 500000), iter("I", 250000) + iter("J", 250000), 250000);
				}
				printlnColored("Hard Test 2 - large remove", "\033[4m\033[1;35m%s\033[0m");
				{
					printColored("* Test 1:", "\033[1;34m%s\033[0m");
					hard_check((String u, String v) -> {
						LinkedString ls = new LinkedString(u);
						ls.remove(v);
						return ls.toString();
					}, iter("kipkipa", 100000) + iter("a", 100000), "kipa", "");
					printColored("* Test 2:", "\033[1;34m%s\033[0m");
					hard_check((String u, String v) -> {
						LinkedString ls = new LinkedString(u);
						ls.remove(v);
						return ls.toString();
					}, iter("a", 500000) + iter("b", 499999) + "cb", "ab", "acb");
					printColored("* Test 3:", "\033[1;34m%s\033[0m");
					hard_check((String u, String v) -> {
						LinkedString ls = new LinkedString(u);
						ls.remove(v);
						return ls.toString();
					}, iter("a", 999999) + "b", iter("a", 499999) + "b", iter("a", 500000));
					printColored("* Test 4:", "\033[1;34m%s\033[0m");
					hard_check((String u, String v) -> {
						LinkedString ls = new LinkedString(u);
						ls.remove(v);
						return ls.toString();
					}, iter("LovesMeLovesMe", 40000) + iter("LovesMeNot", 40000), iter("LovesMeLovesMe", 19999) + "LovesMeLovesMeNat",
					iter("LovesMeLovesMe", 40000) + iter("LovesMeNot", 40000));
					printColored("* Test 5:", "\033[1;34m%s\033[0m");
					hard_check((String u, String v) -> {
						LinkedString ls = new LinkedString(u);
						ls.remove(v);
						return ls.toString();
					}, iter(iter("a", 999) + "b", 2000), iter("a", 499) + "b", iter("a", 1000000));
					printColored("* Test 6:", "\033[1;34m%s\033[0m");
					{
						String s = makeString(999);
						hard_check((String u, String v) -> {
							LinkedString ls = new LinkedString(u);
							ls.remove(v);
							return ls.toString();
						}, iter(s, 2000) + iter("`", 2000), s + "`", "");
					}
				}
				//*/
			}
		} else {
			printColored("Cannot continue", "\033[4m\033[1;31m%s\033[0m");
			printlnColored(" - Checking equality on all of the remaining tests depends on toString().", "\033[1;31m%s\033[0m");
		}
	}

	private boolean isIn(String[] v, String u) {
		for (String s : v) {
			if (u.equalsIgnoreCase(s)) {
				return true;
			}
		}
		return false;
	}

	private void printlnColored(String v, String format) {
		if (is_windows) {
			System.out.println(v);
		} else {
			System.out.printf(format + "\n", v);
		}
	}

	private void printColored(String v, String format) {
		if (is_windows) {
			System.out.print(v);
		} else {
			System.out.printf(format, v);
		}
	}

	private String makeString(int size) {
		StringBuilder sb = new StringBuilder();
		while (size --> 0) {
			sb.append("0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm".charAt(rand.nextInt(62)));
		}
		return sb.toString();
	}

	private String makeStringDiff(int size) {
		StringBuilder sb = new StringBuilder();
		String flag = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
		while (size --> 0) {
			int v = rand.nextInt(flag.length());
			sb.append(flag.charAt(v));
			flag = flag.substring(0, v) + flag.substring(v + 1);
		}
		return sb.toString();
	}

	private String iter(String s, int c) {
		StringBuilder sb = new StringBuilder();
		while (c --> 0) {
			sb.append(s);
		}
		return sb.toString();
	}

	private boolean check(Checkable c1, Checkable c2) {
		return check(c1, c2, 500, 1000000L);
	}

	private boolean check(Checkable c1, Checkable c2, int c, long max_len) {
		int tc_num = 0, res = -1;
		try {
			for (tc_num = 1; tc_num <= c; ++tc_num) {
				System.out.printf("\rChecking... (%.2f%%)", tc_num * 100. / c);
				boolean err = false;
				String s = makeString((int)(max_len * tc_num / c));
				Object o1 = null, o2 = null;
				try {
					o1 = c1.run(s);
				} catch (Exception e) {
					err = true;
				}
				Thread th = new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							checker = c2.run(s);
						} catch (Exception e) {
							checker = null;
						}
					}
				});
				th.start();
				long stime = System.nanoTime();
				while (th.isAlive()) {
					if (System.nanoTime() - stime > time_limit) {
						break;
					}
				}
				int temp = (int)((System.nanoTime() - stime) / 1000000L);
				res = res < temp ? temp : res;
				if (th.isAlive()) {
					throw new Exception("Time Limit Exceeded on test " + tc_num + ", ^C to exit");
				}
				o2 = checker;
				if (o2 == null) {
					if (err) {
						err = false;
						o1 = o2 = new Object();
					} else {
						throw new Exception("Wrong Answer on test " + tc_num + ": expected " + o1 + ", got AN ERROR");
					}
				}
				if (err) {
					throw new Exception("Wrong Answer on test " + tc_num + ": expected AN ERROR, got " + o2);
				} else if (!o1.equals(o2)) {
					throw new Exception("Wrong Answer on test " + tc_num + ": expected " + o1 + ", got " + o2);
				}
			}
		} catch (Exception err) {
			printlnColored(" " + err.getMessage(), "\033[1;31m%s\033[0m");
			return false;
		} finally {
			if (tc_num == c + 1) {
				printColored(" AC!", "\033[1;32m%s\033[0m");
				System.out.println(" (" + res + "ms)");
			}
		}
		return true;
	}

	private boolean hard_check(HardCheckable c1, String u, String v, Object o) {
		int tc_num = 0, temp = -1;
		try {
			checker = null;
			Thread th = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						checker = c1.run(u, v);
					} catch (Exception err) {
						checker = null;
					}
				}
			});
			th.start();
			long stime = System.nanoTime();
			while (th.isAlive()) {
				if (System.nanoTime() - stime > hard_time_limit) {
					break;
				}
			}
			temp = (int)((System.nanoTime() - stime) / 1000000L);
			if (th.isAlive()) {
				throw new Exception("Time Limit Exceeded, ^C to exit");
			} else if (!o.equals(checker)) {
				throw new Exception("Wrong Answer: expected " + o + ", got " + checker);
			}
			printColored(" ok! ", "\033[1;32m%s\033[0m");
			System.out.println("(" + temp + "ms)");
		} catch (Exception err) {
			printlnColored(" " + err.getMessage(), "\033[1;31m%s\033[0m");
			return false;
		}
		return true;
	}

	public boolean clarity_check(String filename) throws Exception {
		Analyzer a = new Analyzer(filename);
		int i;
		for (i=0; i<a.pool.length; ++i) {
			Analyzer.Pool ap = a.pool[i];
			if (ap instanceof Analyzer.MethodPool) {
				Analyzer.MethodPool amp = (Analyzer.MethodPool)ap;
				String clStr = a.pool[amp.v].toString(a);
				String pretty = a.prettyMethod(amp);
				int notice = 0;
				if (clStr.equals("Class(java/lang/String)")) {
					String anatp = a.pool[amp.w].toString(a);
					String methodName = ((Analyzer.UTFPool)a.pool[((Analyzer.NameAndTypePool)a.pool[amp.w]).v]).v;
					if (Arrays.asList(new String[] {
						"NameAndType(toCharArray:()[C)", "NameAndType(toString:()Ljava/lang/String;)", "NameAndType(charAt:(I)C)",
						"NameAndType(concat:(Ljava/lang/String;)Ljava/lang/String;)", "NameAndType(length:()I)"
					}).contains(anatp) || Arrays.asList(new String[] {
						"<init>"
					}).contains(methodName)) {
						notice = 1;
					} else {
						notice = 2;
					}
				} else if (clStr.equals("Class(java/lang/StringBuilder)")) {
					String anatp = a.pool[amp.w].toString(a);
					String methodName = ((Analyzer.UTFPool)a.pool[((Analyzer.NameAndTypePool)a.pool[amp.w]).v]).v;
					if (Arrays.asList(new String[] {
						"NameAndType(<init>:()V)", "NameAndType(toString:()Ljava/lang/String;)"
					}).contains(anatp) || Arrays.asList(new String[] {
						"append"
					}).contains(methodName)) {
						notice = 1;
					} else {
						notice = 2;
					}
				} else if (clStr.equals("Class(java/util/LinkedList)")) {
					notice = 2;
				}
				if (notice == 1) {
					System.out.print("Safe and happy little method ");
					printColored(pretty, "\033[1;36m%s\033[0m");
					System.out.print(" detected. ");
					printlnColored("Good to go.", "\033[5m\033[1;32m%s\033[0m");
				} else if (notice == 2) {
					System.out.print("Dangerous and ugly monstrous method ");
					printColored(pretty, "\033[1;36m%s\033[0m");
					System.out.print(" detected. ");
					printlnColored("Cannot continue.", "\033[5m\033[1;31m%s\033[0m");
					return false;
				}
			}
		}
		return true;
	}

}
