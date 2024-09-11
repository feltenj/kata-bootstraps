function add(number: string): number {
    if (number === "1") {
      return 1;
    } else if(number === "") {
        return 0;
    }

    let splittedEquation = number.split(",");
    if (splittedEquation.length === 1){
        return Number(splittedEquation[0]);
    }
    return Number(splittedEquation[0]) + Number(splittedEquation[1]);
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
        expect(add("1,2")).toEqual(3);
    });
});

describe("Should return 2 when input 2", () => {
    it("succeeds", () => {
        expect(add("2")).toEqual(2);
    });
});

