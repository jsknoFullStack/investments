import React, { Component } from "react";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { deleteTransaction } from "../../actions/transactionActions";

class TransactionItem extends Component {
  onDeleteClick = id => {
    this.props.deleteTransaction(id);
  };

  render() {
    const { transaction } = this.props;
    return (
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-2">
              <span className="mx-auto">{transaction.id}</span>
            </div>
            <div className="col-lg-6 col-md-4 col-8">
              <h3>{transaction.investmentType.description}</h3>
              <p>{transaction.transactionType.description}</p>
            </div>
            <div className="col-md-4 d-none d-lg-block">
              <ul className="list-group">
                <Link to={`/updateTransaction/${transaction.id}`}>
                  <li className="list-group-item board">
                    <i className="fa fa-flag-checkered pr-1">
                      {" "}
                      Transaction Board
                    </i>
                  </li>
                </Link>
                <Link to={`/updateTransaction/${transaction.id}`}>
                  <li className="list-group-item update">
                    <i className="fa fa-edit pr-1"> Update Transaction</i>
                  </li>
                </Link>

                <li
                  className="list-group-item delete"
                  onClick={this.onDeleteClick.bind(this, transaction.id)}
                >
                  <i className="fa fa-minus-circle pr-1"> Delete Transaction</i>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

TransactionItem.propTypes = {
  deleteTransaction: PropTypes.func.isRequired
};

export default connect(
  null,
  { deleteTransaction }
)(TransactionItem);
