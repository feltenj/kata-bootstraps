import {add} from "./string_calculator";

describe("A Test", () => {
  it("fails", () => {
    expect(false as boolean).toEqual(true as boolean);
  });

    it("succeeds", () => {
    expect(true as boolean).toEqual(true as boolean);
  });

  it("runs add()", () => {
    expect(add("1, 2")).toEqual(true as boolean);
  });

});
