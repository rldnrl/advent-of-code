const adventOfCode1 = (arr: Array<number>): number => {
  let count = 0;

  for (let i = 0; i < arr.length - 1; i++) {
    if (arr[i + 1] - arr[i] > 0) count++;
  }

  return count;
};

const arr = [199, 200, 208, 210, 200, 207, 240, 269, 260, 263];
console.log(adventOfCode1(arr));
