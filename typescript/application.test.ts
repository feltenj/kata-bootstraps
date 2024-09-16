function add(number: string): string {
   if (number === "") {
        return "0";
    }

    let sum = number.split(",").reduce((sum, current) => {
        return Number(sum) + Number(current);
    }, 0);

    return String(Math.round(sum * 10)/10);
}

describe("Should return 0 when input empty", () => {
    it("succeeds", () => {
        expect(add("")).toEqual("0");
    });
});

describe("Should return 1 when input 1", () => {
    it("succeeds", () => {
        expect(add("1")).toEqual("1");
    });
});

describe("Comma separated input should add the separated values", () => {
    it("succeeds", () => {
        expect(add("1,2")).toEqual("3");
    });
});

describe("Should return 2 when input 2", () => {
    it("succeeds", () => {
        expect(add("2")).toEqual("2");
    });
});

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

describe("When input is ", () => {

});
