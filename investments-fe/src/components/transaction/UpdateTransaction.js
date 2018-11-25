import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import {
  createTransaction,
  getTransaction
} from "../../actions/transactionActions";
import classnames from "classnames";

class UpdateTransaction extends Component {
  constructor() {
    super();
    this.state = {
      investmentType: "",
      transactionType: "",
      price: "",
      shares: "",
      transactionDate: "",
      errors: {}
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  componentDidMount() {
    const { id } = this.props.match.params;
    this.props.getTransaction(id, this.props.history);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
    const {
      id,
      investmentType,
      transactionType,
      price,
      shares,
      transactionDate
    } = nextProps.transaction;

    this.setState({
      id,
      investmentType,
      transactionType,
      price,
      shares,
      transactionDate
    });
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    const updateTransaction = {
      id: this.state.id,
      investmentType: this.state.investmentType,
      transactionType: this.state.transactionType,
      price: this.state.price,
      shares: this.state.shares,
      transactionDate: this.state.transactionDate
    };

    this.props.createTransaction(updateTransaction, this.props.history);
  }

  render() {
    const { errors } = this.state;
    return (
      <div>
        <div className="transaction">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h5 className="display-4 text-center">
                  Update Transaction form
                </h5>
                <hr />
                <form onSubmit={this.onSubmit}>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.investmentType
                      })}
                      placeholder="Investment Type"
                      name="investmentType"
                      value={this.state.investmentType}
                      onChange={this.onChange}
                    />
                    {errors.investmentType && (
                      <div className="invalid-feedback">
                        {errors.investmentType}
                      </div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="text"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.transactionType
                      })}
                      placeholder="Transaction Type"
                      name="transactionType"
                      value={this.state.transactionType}
                      onChange={this.onChange}
                    />
                    {errors.transactionType && (
                      <div className="invalid-feedback">
                        {errors.transactionType}
                      </div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="number"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.price
                      })}
                      placeholder="Transaction Price"
                      name="price"
                      value={this.state.price}
                      onChange={this.onChange}
                    />
                    {errors.price && (
                      <div className="invalid-feedback">{errors.price}</div>
                    )}
                  </div>
                  <div className="form-group">
                    <input
                      type="number"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.shares
                      })}
                      placeholder="Transaction Units"
                      name="shares"
                      value={this.state.shares}
                      onChange={this.onChange}
                    />
                    {errors.shares && (
                      <div className="invalid-feedback">{errors.shares}</div>
                    )}
                  </div>
                  <h6>Transaction Date</h6>
                  <div className="form-group">
                    <input
                      type="date"
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.transactionDate
                      })}
                      name="transactionDate"
                      value={this.state.transactionDate}
                      onChange={this.onChange}
                    />
                    {errors.transactionDate && (
                      <div className="invalid-feedback">
                        {errors.transactionDate}
                      </div>
                    )}
                  </div>

                  <input
                    type="submit"
                    className="btn btn-primary btn-block mt-4"
                  />
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

UpdateTransaction.propTypes = {
  getTransaction: PropTypes.func.isRequired,
  transaction: PropTypes.object.isRequired,
  createTransaction: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  transaction: state.appTransaction.transaction,
  errors: state.errors
});

export default connect(
  mapStateToProps,
  { getTransaction, createTransaction }
)(UpdateTransaction);
