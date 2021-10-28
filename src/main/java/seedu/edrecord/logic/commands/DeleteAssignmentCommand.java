package seedu.edrecord.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.edrecord.commons.core.Messages;
import seedu.edrecord.commons.core.index.Index;
import seedu.edrecord.logic.commands.exceptions.CommandException;
import seedu.edrecord.model.Model;
import seedu.edrecord.model.assignment.Assignment;

/**
 * Deletes an assignment from Edrecord using its displayed index.
 */
public class DeleteAssignmentCommand extends Command {

    public static final String COMMAND_WORD = "dlasg";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes an assignment using its index number used in the displayed assignment list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_ASSIGNMENT_SUCCESS = "Deleted assignment: %1$s";

    private final Index targetIndex;

    public DeleteAssignmentCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.hasSelectedModule()) {
            throw new CommandException(Messages.MESSAGE_NO_MODULE_SELECTED);
        }
        List<Assignment> assignmentList = model.getAssignmentList();

        if (targetIndex.getZeroBased() >= assignmentList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_ASSIGNMENT_DISPLAYED_INDEX);
        }

        Assignment assignmentToDelete = assignmentList.get(targetIndex.getZeroBased());
        model.deleteAssignment(assignmentToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_ASSIGNMENT_SUCCESS, assignmentToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteAssignmentCommand // instanceof handles nulls
                && targetIndex.equals(((DeleteAssignmentCommand) other).targetIndex)); // state check
    }
}