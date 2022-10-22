package br.com.desafio.iti;

public class StudyingExceptions {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		try {
			method1();
			System.out.println("Funcionou");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void method1() throws Exception {
		try {
			method2();
		} catch (MyOtherException e) {
			throw e;
		} catch (MyException2 e) {
			throw new MyOtherException("OtherBy2OnMethod1");
		} catch (MyException1 e) {
			throw new MyOtherException("OtherBy1OnMethod1");
		}
	}

	public static void method2() throws Exception {
		try {
			method3();
		} catch (MyException3 e) {
			throw e;
		} catch (MyException2 e) {
			throw new MyOtherException("OtherBy2OnMethod2");
		} catch (MyException1 e) {
			throw new MyOtherException("OtherBy1OnMethod2");
		}
	}

	public static void method3() throws Exception {
		try {
			method4();
		} catch (MyOtherException e) {
			throw e;
		} catch (MyException3 e) {
			throw new MyOtherException("OtherExceptionBy3OnMethod3");
		} catch (MyException2 e) {
			throw new MyOtherException("OtherExceptionBy2OnMethod3");
		} catch (MyException1 e) {
			throw new MyOtherException("OtherExceptionBy1OnMethod3");
		} catch (Exception e) {
			throw new MyOtherException("OtherExceptionByBaseOnMethod3");
		}
	}

	public static void method4() throws Exception {
		throw new MyException2("Exception2");
	}

	public static class MyException1 extends Exception {
		public MyException1(String msg) {
			super(msg);
		}
	}

	public static class MyException2 extends MyException1 {
		public MyException2(String msg) {
			super(msg);
		}
	}

	public static class MyException3 extends MyException2 {
		public MyException3(String msg) {
			super(msg);
		}
	}

	public static class MyOtherException extends MyException1 {
		public MyOtherException(String msg) {
			super(msg);
		}
	}
}
