from typing import List


def advent_of_code_1(arr: List[int]) -> int:
    n = len(arr)

    count = 0
    for i in range(n-1):
        if arr[i + 1] - arr[i] > 0:
            count += 1

    return count


arr = [199, 200, 208, 210, 200, 207, 240, 269, 260, 263]
print(advent_of_code_1(arr))
