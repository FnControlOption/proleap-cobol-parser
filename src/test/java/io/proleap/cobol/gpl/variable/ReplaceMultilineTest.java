package io.proleap.cobol.gpl.variable;

import java.io.File;

import io.proleap.cobol.applicationcontext.CobolGrammarContextFactory;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;
import io.proleap.cobol.runner.CobolParseTestRunner;
import io.proleap.cobol.runner.impl.CobolParseTestRunnerImpl;
import org.junit.Test;

public class ReplaceMultilineTest {

	@Test
	public void test() throws Exception {
		CobolGrammarContextFactory.configureDefaultApplicationContext();

		final File inputFile = new File("src/test/resources/io/proleap/cobol/gpl/variable/ReplaceMultiline.cbl");
		final CobolParseTestRunner runner = new CobolParseTestRunnerImpl();
		runner.parseFile(inputFile, CobolSourceFormatEnum.VARIABLE);
	}
}