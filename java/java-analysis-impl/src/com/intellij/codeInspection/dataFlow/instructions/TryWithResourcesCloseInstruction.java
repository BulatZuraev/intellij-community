package com.intellij.codeInspection.dataFlow.instructions;

import com.intellij.codeInspection.dataFlow.DataFlowRunner;
import com.intellij.codeInspection.dataFlow.DfaInstructionState;
import com.intellij.codeInspection.dataFlow.DfaMemoryState;
import com.intellij.codeInspection.dataFlow.InstructionVisitor;
import com.intellij.codeInspection.dataFlow.value.DfaValue;

public class TryWithResourcesCloseInstruction extends Instruction {
  private final DfaValue myValue;

  public TryWithResourcesCloseInstruction(DfaValue value) {
    myValue = value;
  }

  @Override
  public DfaInstructionState[] accept(DataFlowRunner runner, DfaMemoryState stateBefore, InstructionVisitor visitor) {
    return visitor.visitCloseMethod(this, runner, stateBefore, myValue);
  }

  public String toString() {
    return "TRY_WITH_RESOURCES_CLOSE";
  }
}
