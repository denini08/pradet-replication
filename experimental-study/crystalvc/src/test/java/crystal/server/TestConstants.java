package crystal.server;

import java.io.File;
import java.util.Vector;

import org.junit.Ignore;

import crystal.client.ConflictSystemTray;

@Ignore
public class TestConstants {

	static {
		ConflictSystemTray.startLogging();
	}

	public static String PROJECT_PATH = null;
	static {
		/**
		 * This should contain the path to your workspace project location.
		 */
		Vector<String> possiblePaths = new Vector<String>();
		possiblePaths.add("/var/lib/jenkins/jobs/crystalvc/workspace/"); // for ci server
		possiblePaths.add("/Users/rtholmes/Workspaces/inconsistencyworkspace/crystalvc/"); // MBA
		possiblePaths.add("C:\\Users\\Yuriy\\Desktop\\work\\crystalSource");
		possiblePaths.add("C:\\Users\\brun\\work\\crystalCode");
		//possiblePaths.add("/home/skappler/Programming/dependent-tests-impact/myexperiments/crystalvc");
		possiblePaths.add( System.getProperty("user.dir") );
		possiblePaths.add("/home/skappler/Programming/master/poldet/scripts_bash/projects/crystalvc/");
		//
		possiblePaths.add("/Users/gambi/Documents/Saarland/Master.Theses/Sebastian.Klapper/poldet/scripts_bash/projects/crystalvc/");
		//
		possiblePaths.add("/scratch/Sebastian.Kappler/poldet/scripts_bash/projects/crystalvc/");
		System.out.println("loading right file");

		for (String possiblePath : possiblePaths) {
			if (new File(possiblePath).exists()) {
                                System.out.println("file " + possiblePath + " exists !");

				PROJECT_PATH = possiblePath;
				break;
			} else {
		                System.out.println("file " + possiblePath + " does not exists !");
	                        System.out.println("Absolute path " + new File(possiblePath).getAbsolutePath());
			}
		}

		assert PROJECT_PATH != null : "Make sure your project path is in possiblePaths above. The SRC file is right";

		if (!PROJECT_PATH.endsWith(File.separator)) {
			PROJECT_PATH += File.separator;
		}

		System.out.println("Constants::<clinit> - working path: " + PROJECT_PATH);
	}

	public static String HG_COMMAND = null;
	static {
		/**
		 * This should contain the path to your hg binary.
		 */
		Vector<String> possiblePaths = new Vector<String>();
		possiblePaths.add("/usr/local/bin/hg"); // for os x
		possiblePaths.add("/usr/bin/hg"); // for ci server
		possiblePaths.add("C:\\Program Files (x86)\\TortoiseHg\\hg.exe");
		possiblePaths.add("hg");
		possiblePaths.add("C:\\Program Files\\TortoiseHg\\hg.exe");
		// possiblePaths.add("\"C:\\Program Files\\TortoiseHg\\hg.exe\"");

		for (String possiblePath : possiblePaths) {
			if (new File(possiblePath).exists()) {
				HG_COMMAND = possiblePath;
				break;
			}
		}

		assert HG_COMMAND != null : "Make sure your hg binary is in possiblePaths above.";
		assert new File(HG_COMMAND).exists() : "Cannot find hg executable; this must be defined";

		System.out.println("Constants::<clinit> - HG path: " + HG_COMMAND);
	}

	public static final String TEST_REPOS = "test-repos" + File.separator;
	public static final String TEST_TEMP = "test-temp" + File.separator;
}
