import React, { Component } from "react";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { createTransaction } from "../../actions/transactionActions";
import { getInvestmentTypes } from "../../actions/investmentTypeActions";
import classnames from "classnames";

class AddTransaction extends Component {
  constructor() {
    super();
    this.state = {
      investmentType: "",
      transactionType: "",
      price: "",
      shares: "",
      transactionDate: "",
      investmentTypes: [],
      errors: {}
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  componentDidMount() {
    this.props.getInvestmentTypes();
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.errors) {
      this.setState({ errors: nextProps.errors });
    }
    const { investmentTypes } = nextProps;
    this.setState({ investmentTypes: investmentTypes });
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    const newTransaction = {
      investmentType: this.state.investmentType,
      transactionType: this.state.transactionType,
      price: this.state.price,
      shares: this.state.shares,
      transactionDate: this.state.transactionDate
    };
    this.props.createTransaction(newTransaction, this.props.history);
  }

  render() {
    const { errors } = this.state;
    let options = [];
    const { investmentTypes } = this.state;
    if (investmentTypes.length > 0) {
      options = investmentTypes.map(investmentType => (
        <option key={investmentType.id} value={investmentType.id}>
          {investmentType.description}
        </option>
      ));
    }
    return (
      <div>
        <div className="transaction">
          <div className="container">
            <div className="row">
              <div className="col-md-8 m-auto">
                <h5 className="display-4 text-center">Add Transaction form</h5>
                <hr />
                <form onSubmit={this.onSubmit}>
                  <div className="form-group">
                    <select
                      className={classnames("form-control form-control-lg ", {
                        "is-invalid": errors.investmentType
                      })}
                      placeholder="Investment Type"
                      name="investmentType"
                      value={this.state.investmentType}
                      onChange={this.onChange}
                    >
                      {options}
                    </select>
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
                    {errors.price && (
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

AddTransaction.propTypes = {
  createTransaction: PropTypes.func.isRequired,
  getInvestmentTypes: PropTypes.func.isRequired,
  errors: PropTypes.object.isRequired
};

const mapStateToProps = state => ({
  investmentTypes: state.appInvestmentType.investmentTypes,
  errors: state.errors
});

export default connect(
  mapStateToProps,
  { createTransaction, getInvestmentTypes }
)(AddTransaction);
