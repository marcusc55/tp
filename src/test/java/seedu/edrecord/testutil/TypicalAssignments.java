package seedu.edrecord.testutil;

import seedu.edrecord.model.assignment.Assignment;

public class TypicalAssignments {

    public static final Assignment IP = new AssignmentBuilder()
            .withName("iP").withWeightage("15").withMaxScore("15").build();
    public static final Assignment TP = new AssignmentBuilder()
            .withName("tP").withWeightage("50").withMaxScore("50").build();
    public static final Assignment TUTORIAL = new AssignmentBuilder()
            .withName("tutorial").withWeightage("0.25").withMaxScore("10").build();
    public static final Assignment LAB = new AssignmentBuilder()
            .withName("lab").withWeightage("2.5").withMaxScore("10").build();
    public static final Assignment QUIZ = new AssignmentBuilder()
            .withName("quiz").withWeightage("1.25").withMaxScore("15").build();
    public static final Assignment PE = new AssignmentBuilder()
            .withName("practical exam").withWeightage("15").withMaxScore("25").build();
    public static final Assignment MIDTERM = new AssignmentBuilder()
            .withName("midterm").withWeightage("15").withMaxScore("55").build();
    public static final Assignment FINAL = new AssignmentBuilder()
            .withName("final").withWeightage("40").withMaxScore("100").build();

    private TypicalAssignments() {} // prevents instantiation

}