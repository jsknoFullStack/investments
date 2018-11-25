import React, { Component } from "react";
import { Provider } from "react-redux";
import { BrowserRouter as Router, Route } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import store from "./store";
import Header from "./components/layout/Header";
import Dashboard from "./components/Dashboard";
import AddTransaction from "./components/transaction/AddTransaction";
import UpdateTransaction from "./components/transaction/UpdateTransaction";

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Router>
          <div className="App">
            <Header />
            <Route exact path="/dashboard" component={Dashboard} />
            <Route exact path="/addTransaction" component={AddTransaction} />
            <Route
              exact
              path="/updateTransaction/:id"
              component={UpdateTransaction}
            />
          </div>
        </Router>
      </Provider>
    );
  }
}

export default App;
