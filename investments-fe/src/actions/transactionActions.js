import axios from "axios";
import {
  GET_TRANSACTIONS,
  GET_TRANSACTION,
  DELETE_TRANSACTION,
  GET_ERRORS
} from "./types";

export const createTransaction = (transaction, history) => async dispatch => {
  try {
    await axios.post("/api/investmenttransaction", transaction);
    history.push("/dashboard");
    dispatch({
      type: GET_ERRORS,
      payload: {}
    });
  } catch (error) {
    dispatch({
      type: GET_ERRORS,
      payload: error.response.data
    });
  }
};

export const getTransactions = () => async dispatch => {
  const res = await axios.get("/api/investmenttransaction/all");
  dispatch({
    type: GET_TRANSACTIONS,
    payload: res.data
  });
};

export const getTransaction = (id, history) => async dispatch => {
  try {
    const res = await axios.get(`/api/investmenttransaction/${id}`);
    dispatch({
      type: GET_TRANSACTION,
      payload: res.data
    });
  } catch (err) {
    history.push("/dashboard");
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    });
  }
};

export const deleteTransaction = id => async dispatch => {
  try {
    if (
      window.confirm(
        "Are you sure? This will delete the transaction and all the data related to it"
      )
    ) {
      await axios.delete(`/api/investmenttransaction/${id}`);
      dispatch({
        type: DELETE_TRANSACTION,
        payload: id
      });
    }
  } catch (err) {}
};
