function add(number: string): string {
   if (number === "") {
        return "0";
    }

    let sum = number.split(",").reduce((sum, current) => {
        return Number(sum) + Number(current);
    }, 0);

    return String(Math.round(sum * 10)/10);
}


describe("Comma separated input should add the 3 separated values", () => {
    it("succeeds", () => {
        expect(add("1,2,3")).toEqual("6");
    });
});

describe("Add should work on floats", () => {
    it("succeeds", () => {
        expect(add("1.1,2.2")).toEqual("3.3");
    });
});

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

    it("comma separated values then add should add the values", () => {
        expect(add("1,2")).toEqual("3");
    });
});
