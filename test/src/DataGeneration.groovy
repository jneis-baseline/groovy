def combinations = [[1, 2], [3, 4, 5]].combinations()
assert combinations == [[1,3], [2,3], [1,4], [2,4], [1,5], [2,5]]

[[1, 2], [3, 4, 5]].eachCombination { assert it[0] < it[1] }
