import { combineReducers } from "redux";
import errorReducer from "./errorReducer";
import transactionReducer from "./transactionReducer";
import investmentTypeReducer from "./investmentTypeReducer";

export default combineReducers({
  errors: errorReducer,
  appTransaction: transactionReducer,
  appInvestmentType: investmentTypeReducer
});
