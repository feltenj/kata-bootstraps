function add(number: string): string {
    if (number === "") {
        return "0";
    }
    if (number.includes(",")) {
        let splittedEquation = number.split(",");
        let item1 = Number(splittedEquation[0]);
        let item2 = Number(splittedEquation[1]);

        return String(item1 + item2);

    } else {
        return number;
    }
}


describe("Should return 0 when input empty", () => {
    it("succeeds", () => {
        expect(add("")).toEqual("0");
    });
});


describe("Should return a number when input only one number", () => {
    it("succeeds", () => {
        expect(add("99")).toEqual("99");
    });
});

describe("Comma separated input should add the separated values", () => {
    it("succeeds", () => {
        expect(add("5.1,90")).toEqual("95.1");
    });
});



