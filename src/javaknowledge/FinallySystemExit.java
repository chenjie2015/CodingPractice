package javaknowledge;

import java.security.Permission;
/*
 * The main method implements a SecurityManager,
 * then calls the check() method.
 * If we run this application as is, the output is the following:
 * 
 * Before Check
 * Before System.exit(-1)
 * 
 * We can conclude that:
 * 
 * System.exit(-1) is the last statement executed.
 * Catch and Finally statements are not called.
 * The check() method does not return.
 * 
 * If we uncomment the throw new SecurityException();
 * and execute the application again, we get:
 * 
 * Before Check
 * Before System.exit(-1)
 * Before System.exit(-2)
 * Before System.exit(-3)
 * 
 * We can conclude that:
 * 
 * The SecurityException get the catch and finally statements to be executed.
 * Statements after System.exit() statements are not executed.
 * The check() method does not return.
 */
public class FinallySystemExit {

	public static void main(String[] args) {

		System.setSecurityManager(new SecurityManager() {

			@Override
			public void checkPermission(Permission perm) {
			}

			@Override
			public void checkExit(int status) {
				// throw new SecurityException();
			}

		});

		System.out.println("Before Check");
		check();
		System.out.println("After Check");

	}

	public static void check() {

		try {

			System.out.println("Before System.exit(-1)");
			System.exit(-1);
			System.out.println("After System.exit(-1)");

		} catch (Throwable t) {

			System.out.println("Before System.exit(-2)");
			System.exit(-2);
			System.out.println("After System.exit(-2)");

		} finally {

			System.out.println("Before System.exit(-3)");
			System.exit(-3);
			System.out.println("After System.exit(-3)");

		}

		System.out.println("After try statement");

	}

}
