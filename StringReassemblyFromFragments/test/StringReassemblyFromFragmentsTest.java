import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.set.Set;
import components.set.Set2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

public class StringReassemblyFromFragmentsTest {

    @Test //Edge Test
    public void combinationTest() {
        int overlap = 1;
        String str1 = "J";
        String str2 = "J";
        String str1Expected = "J";
        String str2Expected = "J";
        String expected = "J";
        String actual = StringReassembly.combination(str1Expected, str2Expected,
                overlap);
        assertEquals(expected, actual);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
    }

    @Test //Test routine
    public void combinationTest2() {
        int overlap = 1;
        String str1 = "J";
        String str2 = "Joe";
        String str1Expected = "J";
        String str2Expected = "Joe";
        String expected = "Joe";
        String actual = StringReassembly.combination(str1, str2, overlap);
        assertEquals(expected, actual);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
    }

    @Test //Test routine
    public void combinationTest3() {
        int overlap = 2;
        String str1 = "Hello";
        String str2 = "loki";
        String str1Expected = "Hello";
        String str2Expected = "loki";
        String expected = "Helloki";
        String actual = StringReassembly.combination(str1, str2, overlap);
        assertEquals(expected, actual);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
    }

    @Test //Test no overlap should give back the two combined
    public void combinationTest4() {
        int overlap = 0;
        String str1 = "Hello";
        String str2 = "CoolBeans";
        String str1Expected = "Hello";
        String str2Expected = "CoolBeans";
        String expected = "HelloCoolBeans";
        String actual = StringReassembly.combination(str1, str2, overlap);
        assertEquals(expected, actual);
        assertEquals(str1Expected, str1);
        assertEquals(str2Expected, str2);
    }

    @Test //Test b which is substring of a string in a
    public void addToSetAvoidingSubstringsTest() {
        Set<String> a = new Set2<>();
        a.add("ArthurThoman");
        String b = "man";

        Set<String> aExpected = new Set2<String>();
        aExpected.add("ArthurThoman");
        String bExpected = "man";

        StringReassembly.addToSetAvoidingSubstrings(a, b);

        assertEquals(aExpected, a);
        assertEquals(bExpected, b);
    }

    @Test //Test b which is not a substring of a string in a
    public void addToSetAvoidingSubstrings2Test() {
        Set<String> a = new Set2<>();
        a.add("ArthurThoman");
        String b = "Hero";

        Set<String> aExpected = new Set2<String>();
        aExpected.add("ArthurThoman");
        aExpected.add("Hero");
        String bExpected = "Hero";

        StringReassembly.addToSetAvoidingSubstrings(a, b);

        assertEquals(aExpected, a);
        assertEquals(bExpected, b);
    }

    @Test
    //Test b that is not a substring of a string in a,but a is a substring of b
    public void addToSetAvoidingSubstrings3Test() {
        Set<String> a = new Set2<>();
        a.add("Lady");
        String b = "MyLady";

        Set<String> aExpected = new Set2<String>();
        aExpected.add("MyLady");
        String bExpected = "MyLady";

        StringReassembly.addToSetAvoidingSubstrings(a, b);

        assertEquals(aExpected, a);
        assertEquals(bExpected, b);
    }

    @Test
    /*
     * Test b that is not a substring of a string in a,but several string in a
     * are a substring of b
     */
    public void addToSetAvoidingSubstringsTest4() {
        Set<String> a = new Set2<>();
        a.add("Lady");
        a.add("ady");
        String b = "MyLady";

        Set<String> aExpected = new Set2<String>();
        aExpected.add("MyLady");
        String bExpected = "MyLady";

        StringReassembly.addToSetAvoidingSubstrings(a, b);

        assertEquals(aExpected, a);
        assertEquals(bExpected, b);
    }

    @Test
    /*
     * String b is not a substring of all strings in a. All strings in a are not
     * substrings of b
     */
    public void addToSetAvoidingSubstringsTest5() {
        Set<String> a = new Set2<>();
        a.add("Lady");
        String b = "CoolBeans";

        Set<String> aExpected = new Set2<String>();
        aExpected.add("Lady");
        aExpected.add("CoolBeans");
        String bExpected = "CoolBeans";

        StringReassembly.addToSetAvoidingSubstrings(a, b);

        assertEquals(aExpected, a);
        assertEquals(bExpected, b);
    }

    @Test // Test routine with no duplicates in file
    public void linesFromInput() {
        SimpleReader in = new SimpleReader1L("test/JunitTextFile.txt");
        Set<String> a = StringReassembly.linesFromInput(in);

        Set<String> aExpected = new Set2<>();
        aExpected.add("Hello");
        aExpected.add("My");
        aExpected.add("Name");
        aExpected.add("Is");
        aExpected.add("Yihone");
        aExpected.add("Alexander");
        aExpected.add("Chu");

        assertEquals(aExpected, a);
    }

    @Test //Test duplicates in the file
    public void linesFromInput2() {
        SimpleReader in = new SimpleReader1L("test/JUnitTextFile2.txt");
        Set<String> a = StringReassembly.linesFromInput(in);

        Set<String> aExpected = new Set2<>();
        aExpected.add("hello");
        assertEquals(aExpected, a);
    }

    @Test //Test file with duplicates and some non duplicates
    public void linesFromInput3() {
        SimpleReader in = new SimpleReader1L("test/JUnitTextFile3.txt");
        Set<String> a = StringReassembly.linesFromInput(in);

        Set<String> aExpected = new Set2<>();
        aExpected.add("Hello");
        aExpected.add("Cool");
        aExpected.add("Beans");
        assertEquals(aExpected, a);
    }

    @Test
    /*
     * Test file with duplicates, non duplicates, strings that are substrings of
     * another
     */
    public void linesFromInput4() {
        SimpleReader in = new SimpleReader1L("test/JUnitTextFile4.txt");
        Set<String> a = StringReassembly.linesFromInput(in);

        Set<String> aExpected = new Set2<>();
        aExpected.add("Hello");
        aExpected.add("Cool");
        aExpected.add("Beans");
        assertEquals(aExpected, a);
    }

    @Test //Test edge a file with nothing
    public void linesFromInput5() {
        SimpleReader in = new SimpleReader1L("test/JUnitTextFile5.txt");
        Set<String> a = StringReassembly.linesFromInput(in);

        Set<String> aExpected = new Set2<>();
        assertEquals(aExpected, a);
    }

    @Test //Test routine
    public void printWithLineSeparatorsTest() {
        SimpleWriter out = new SimpleWriter1L("test/Lines1.txt");
        String str1 = "Hel~lo";
        StringReassembly.printWithLineSeparators(str1, out);

        assertTrue(out.isOpen());
        out.close();
        SimpleReader in = new SimpleReader1L("test/Lines1.txt");
        String result = "";

        while (!in.atEOS()) {
            char temp = in.read();

            if (temp == '\n' && !in.atEOS()) {
                result += '~';
            } else {
                result += temp;
            }
        }
        in.close();
        assertEquals(str1, result);
    }

    @Test //Test squiggle at beginning
    public void printWithLineSeparatorsTest2() {
        SimpleWriter out = new SimpleWriter1L("test/Lines2.txt");
        String str1 = "~Hello";
        StringReassembly.printWithLineSeparators(str1, out);

        assertTrue(out.isOpen());
        out.close();

        SimpleReader in = new SimpleReader1L("test/Lines2.txt");
        String result = "";

        while (!in.atEOS()) {
            char temp = in.read();

            if (temp == '\n' && !in.atEOS()) {
                result += '~';
            } else {
                result += temp;
            }
        }
        in.close();
        assertEquals(str1, result);
    }

    @Test //Test multiple squiggles throughout string
    public void printWithLineSeparatorsTest3() {
        SimpleWriter out = new SimpleWriter1L("test/Lines3.txt");
        String str1 = "~He~ll~o";
        StringReassembly.printWithLineSeparators(str1, out);

        assertTrue(out.isOpen());
        out.close();

        SimpleReader in = new SimpleReader1L("test/Lines3.txt");
        String result = "";

        while (!in.atEOS()) {
            char temp = in.read();

            if (temp == '\n' && !in.atEOS()) {
                result += '~';
            } else {
                result += temp;
            }
        }
        in.close();
        assertEquals(str1, result);
    }

}
