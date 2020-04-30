import React from 'react'
import './css/App.css'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import NavBar from './components/NavBar'
import Home from './components/Home'
import About from './components/About'
import SignUp from './components/SignUp'
import Admin from './components/Admin'
import { DataProvider } from './context/DataContext'

export default function App() {
  const [ tableData, setTableData ] = React.useState(null)
  const tableContext = { tableData: tableData, updateTable: (data) => { setTableData(data) } }

  return (
    <div className="App">
      <DataProvider value={tableContext}>
        <Router>
          <NavBar />
          <Switch>
            <Route exact path='/' component={Home} />
            <Route path='/about' component={About} />
            <Route path='/signup' component={SignUp} />
            <Route path='/admin' component={Admin} />
          </Switch>
        </Router>
      </DataProvider>
    </div>
  )
}