import React, { Component } from "react";
import { connect } from "react-redux";
import { getTransactions } from "../actions/transactionActions";
import PropTypes from "prop-types";
import CreateTransactionButton from "./transaction/CreateTransactionButton";
import TransactionItem from "./transaction/TransactionItem";

class Dashboard extends Component {
  componentDidMount() {
    this.props.getTransactions();
  }

  render() {
    const { transactions } = this.props;
    return (
      <div className="transactions">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Transactions</h1>
              <br />
              <CreateTransactionButton />
              <br />
              <hr />
              {transactions.map(transaction => (
                <TransactionItem
                  key={transaction.id}
                  transaction={transaction}
                />
              ))}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

Dashboard.propTypes = {
  transactions: PropTypes.array.isRequired,
  getTransactions: PropTypes.func.isRequired
};

const mapStateToProps = state => ({
  transactions: state.appTransaction.transactions
});

export default connect(
  mapStateToProps,
  { getTransactions }
)(Dashboard);
