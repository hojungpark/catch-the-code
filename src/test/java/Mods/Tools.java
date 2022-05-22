package test.Mods;

import org.junit.jupiter.api.Assertions;

public class Tools {
    public static void OutPutOnLine(){
        System.out.print("------------------------------------------------------------------------------------------------------------------------\n");
    }
    public static void AutoTestMenu() {
        OutPutOnLine();
        System.out.print("|    Main Class    |    Sub Class    |    Var Name    |    Sub Name    |    In_Var    |  Expect Data  |   Real Data    |\n");
        OutPutOnLine();
    }

    public static void AutoTestNums(String MainClass, String SubClass, String VarName, String SubName,
                                    String Inter_Var, double Expect_s, double RealDat) {
        System.out.printf("| %16s | %15s | %14s | %14s | %12s | %13.4f |  %13.4f |\n", MainClass, SubClass,
                VarName, SubName, Inter_Var, Expect_s, RealDat);
        Assertions.assertEquals(Expect_s, RealDat);
    }

    public static void AutoTestText(String MainClass, String SubClass, String VarName, String SubName,
                                    String Inter_Var, String Expect_s, String RealDat) {
        System.out.printf("| %16s | %15s | %14s | %14s | %12s | %13s |  %13s |\n", MainClass, SubClass,
                VarName, SubName, Inter_Var, Expect_s, RealDat);
        Assertions.assertEquals(Expect_s, RealDat);
    }

    public static void AutoTestObjs(String MainClass, String SubClass, String VarName, String SubName,
                                    String Inter_Var, Object Expect_s, Object RealDat) {

        System.out.printf("| %16s | %15s | %14s | %14s | %12s | %13s |  %13s |\n", MainClass, SubClass,
                    VarName, SubName, Inter_Var, Expect_s, RealDat);

        Assertions.assertEquals(Expect_s, RealDat);
    }

}
