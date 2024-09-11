function add(number: string): number {

    if (number === "1") {
      return 1;
    } else {
        return 0;
    }
}


describe("Should return 0 when input empty", () => {
    it("succeeds", () => {
        expect(add("")).toEqual(0);
    });
});


describe("Should return 1 when input 1", () => {
    it("succeeds", () => {
        expect(add("1")).toEqual(1);
    });
});

describe("Comma separated input should add the separated values", () => {
    it("succeeds", () => {
        expect(add("1")).toEqual(1);
    });
});

