import { GET_INVESTMENT_TYPES } from "../actions/types";

const initialState = {
  investmentTypes: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case GET_INVESTMENT_TYPES:
      return {
        ...state,
        investmentTypes: action.payload
      };

    default:
      return state;
  }
}
