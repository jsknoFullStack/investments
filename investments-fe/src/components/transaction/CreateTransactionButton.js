import React from "react";
import { Link } from "react-router-dom";

const CreateTransactionButton = () => {
  return (
    <React.Fragment>
      <Link to="/addTransaction" className="btn btn-lg btn-info">
        Add a Transaction
      </Link>
    </React.Fragment>
  );
};

export default CreateTransactionButton;
