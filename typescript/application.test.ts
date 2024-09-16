function add(number: string): string {
  if (number === "") {
    return "0";
  }

  let sum = number.split(/[\n|,]/).reduce((sum, current) => {
    return Number(sum) + Number(current);
  }, 0);

  return String(Math.round(sum * 10) / 10);
}

describe("When input is", () => {
  it("empty, sum should return 0", () => {
    expect(add("")).toEqual("0");
  });

  it("1, sum should return 1", () => {
    expect(add("1")).toEqual("1");
  });

  it("2, sum should return 2", () => {
    expect(add("2")).toEqual("2");
  });

  it("2 comma separated values then add should add the values", () => {
    expect(add("1,2")).toEqual("3");
  });
  it("more then 2 comma separated values then return sum", () => {
    expect(add("1,2,3")).toEqual("6");
  });
  it("float then return sum", () => {
    expect(add("1.1,2.2")).toEqual("3.3");
  });
  it("seperated with \n then it should work as a seperator like a comma", () => {
    expect(add("1\n2,3")).toEqual("6");
  });
});

describe("Is inputValid is", () => {});
