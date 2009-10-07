package com.intellij.tapestry.tests;

import com.intellij.codeInspection.LocalInspectionTool;
import com.intellij.codeInspection.htmlInspections.RequiredAttributesInspection;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * @author Alexey Chmutov
 *         Date: Jul 16, 2009
 *         Time: 6:11:55 PM
 */
public class TapestryHighlightingTest extends TapestryBaseTestCase {
  @Override
  protected String getBasePath() {
    return "highlighting/";
  }

  public void testTmlTagNameUsingSubpackage() throws Throwable {
    addComponentToProject("other.Count");
    doTest();
  }

  public void _testTmlAttrName() throws Throwable {
    addComponentToProject("Count");
    doTest();
  }

  public void _testTmlAttrNameInHtmlTag() throws Throwable {
    doTest();
  }

  public void testUnknownTypeOfTag() throws Throwable {
    addComponentToProject("Count");
    doTest();
  }

  public void testAttrNameWithUnknownPrefixInHtmlTag() throws Throwable {
    addComponentToProject("Count");
    doTest();
  }

  public void _testTmlAttrNameWithPrefix() throws Throwable {
    addComponentToProject("Count");
    doTest(new RequiredAttributesInspection());
  }

  protected void doTest(LocalInspectionTool... tools) throws Throwable {
    VirtualFile templateFile = initByComponent(true);
    myFixture.enableInspections(tools);
    myFixture.testHighlighting(true, true, true, templateFile);
  }

  protected void doWarningsOnlyTest(LocalInspectionTool... tools) throws Throwable {
    VirtualFile templateFile = initByComponent(true);
    myFixture.enableInspections(tools);
    myFixture.testHighlighting(true, false, false, templateFile);
  }

}
