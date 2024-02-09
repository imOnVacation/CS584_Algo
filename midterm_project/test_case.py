import random
import math


def generate_random_array(size, range_start, range_end):
    return [random.randint(range_start, range_end) for _ in range(size)]


def generate_array_with_swaps(size):
    arr = list(range(size))
    swaps = math.ceil(math.log2(size) / 2)

    for _ in range(swaps):
        index1, index2 = random.sample(range(size), 2)
        arr[index1], arr[index2] = arr[index2], arr[index1]

    return arr
