import React from 'react'
import './css/App.css'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import NavBar from './components/NavBar'
import Home from './components/Home'
import About from './components/About'
import SignUp from './components/SignUp'
import Admin from './components/Admin'

export default function App() {
  const [data, setData] = React.useState(null)

  return (
   <div className="App">
      <Router>
        <NavBar tableData={data} filterTable={(data) => setData(data)} />
        <Switch>
          <Route exact path='/' render={props => (<Home {...props} updateData={data} updateTable={(data) => setData(data)} />)} />
          <Route path='/about' component={About} />
          <Route path='/signup' component={SignUp} />
          <Route path='/admin' component={Admin} />
        </Switch>
      </Router>
    </div>
  )
}