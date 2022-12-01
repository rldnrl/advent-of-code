type Direction = "forward" | "up" | "down";

function getPosition(arr: [Direction, number][]) {
  let position = [0, 0];

  arr.forEach(([direction, distance]) => {
    switch (direction) {
      case "forward":
        position[0] += distance;
        break;
      case "down":
        position[1] += distance;
        break;
      case "up":
        position[1] -= distance;
        break;
      default:
        break;
    }
  });

  return position[0] * position[1];
}

console.log(
  getPosition([
    ["forward", 5],
    ["down", 5],
    ["forward", 8],
    ["up", 3],
    ["down", 8],
    ["forward", 2],
  ])
); // 150
