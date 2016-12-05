package io.proleap.cobol.asg.procedure.set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import io.proleap.cobol.CobolTestSupport;
import io.proleap.cobol.asg.applicationcontext.CobolParserContext;
import io.proleap.cobol.asg.metamodel.CompilationUnit;
import io.proleap.cobol.asg.metamodel.Program;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.call.Call;
import io.proleap.cobol.asg.metamodel.procedure.ProcedureDivision;
import io.proleap.cobol.asg.metamodel.procedure.StatementTypeEnum;
import io.proleap.cobol.asg.metamodel.procedure.set.By;
import io.proleap.cobol.asg.metamodel.procedure.set.SetBy;
import io.proleap.cobol.asg.metamodel.procedure.set.SetStatement;
import io.proleap.cobol.asg.metamodel.procedure.set.To;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;

public class SetByStatementTest extends CobolTestSupport {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/asg/procedure/set/SetByStatement.cbl");
		final Program program = CobolParserContext.getInstance().getParserRunner().analyzeFile(inputFile,
				CobolSourceFormatEnum.TANDEM);

		final CompilationUnit compilationUnit = program.getCompilationUnit("SetByStatement");
		final ProgramUnit programUnit = compilationUnit.getProgramUnit();
		final ProcedureDivision procedureDivision = programUnit.getProcedureDivision();
		assertEquals(1, procedureDivision.getStatements().size());

		{
			final SetStatement setStatement = (SetStatement) procedureDivision.getStatements().get(0);
			assertNotNull(setStatement);
			assertEquals(StatementTypeEnum.Set, setStatement.getStatementType());
			assertEquals(SetStatement.Type.By, setStatement.getType());

			{
				final SetBy setBy = setStatement.getSetBy();

				{
					assertEquals(2, setBy.getTos().size());

					{
						final To to = setBy.getTos().get(0);
						final Call toCall = to.getToCall();
						assertNotNull(toCall);
						assertEquals(Call.CallType.UndefinedCall, toCall.getCallType());
					}

					{
						final To to = setBy.getTos().get(1);
						final Call toCall = to.getToCall();
						assertNotNull(toCall);
						assertEquals(Call.CallType.UndefinedCall, toCall.getCallType());
					}

					{
						final By by = setBy.getBy();
						assertNotNull(by);

						final Call valueCall = by.getByCall();
						assertNotNull(valueCall);
						assertEquals(Call.CallType.UndefinedCall, valueCall.getCallType());
					}
				}
			}
		}
	}
}