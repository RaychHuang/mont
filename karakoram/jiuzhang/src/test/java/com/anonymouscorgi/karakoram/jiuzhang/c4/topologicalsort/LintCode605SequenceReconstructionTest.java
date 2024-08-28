package com.anonymouscorgi.karakoram.jiuzhang.c4.topologicalsort;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static com.anonymouscorgi.karakoram.jiuzhang.c4.topologicalsort.LintCode605SequenceReconstruction.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LintCode605SequenceReconstructionTest {

  static Stream<Arguments> factoryMethodWithArguments() {
    return Stream.of(
        arguments(
            /* org= */ new int[]{1, 2, 3},
            /* seqs= */ new int[][]{{1, 2}, {1, 3}},
            /* expected= */ false),
        arguments(
            /* org= */ new int[]{1, 2, 3},
            /* seqs= */ new int[][]{{1, 2}},
            /* expected= */ false),
        arguments(
            /* org= */ new int[]{1, 2, 3},
            /* seqs= */ new int[][]{{1, 2}, {1, 3}, {2, 3}},
            /* expected= */ true),
        arguments(
            /* org= */ new int[]{4, 1, 5, 2, 6, 3},
            /* seqs= */ new int[][]{{5, 2, 6, 3}, {4, 1, 5, 2}},
            /* expected= */ true),
        arguments(
            /* org= */ new int[]{1},
            /* seqs= */ new int[][]{},
            /* expected= */ false),
        arguments(
            /* org= */ new int[]{1, 2, 3},
            /* seqs= */ new int[][]{{3, 2}, {2, 1}},
            /* expected= */ false)
    );
  }

  @ParameterizedTest
  @MethodSource("factoryMethodWithArguments")
  void sequenceReconstruction_uto(int[] org, int[][] seqs, boolean expected) {
    assertThat(UniqueTopologicalOrdering_Method.sequenceReconstruction(org, seqs)).isEqualTo(
        expected);
  }

  @ParameterizedTest
  @MethodSource("factoryMethodWithArguments")
  void sequenceReconstruction_verification(int[] org, int[][] seqs, boolean expected) {
    assertThat(Verification_Method.sequenceReconstruction(org, seqs)).isEqualTo(
        expected);
  }
}