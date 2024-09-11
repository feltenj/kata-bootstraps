describe("A Test", () => {
  it("fails", () => {
    expect(false as boolean).toEqual(true as boolean);
  });

    it("succeeds", () => {
    expect(true as boolean).toEqual(true as boolean);
  });

});

describe("Should return 0 when input empty", () => {
  it("fails", () => {
    expect(false as boolean).toEqual(true as boolean);
  });

    it("succeeds", () => {
    expect(add("")).toEqual(0);
  });

});

