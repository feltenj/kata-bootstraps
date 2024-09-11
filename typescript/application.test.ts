function add(number: string): number {
    return 0;
    if (number === "1") {
      return 1;
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

