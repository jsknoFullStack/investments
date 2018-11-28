import axios from "axios";
import { GET_INVESTMENT_TYPES } from "./types";

export const getInvestmentTypes = () => async dispatch => {
  const res = await axios.get("/api/investmenttype/all");
  dispatch({
    type: GET_INVESTMENT_TYPES,
    payload: res.data
  });
};
