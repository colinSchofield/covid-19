import React from 'react'
import './css/App.css'
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom'
import NavBar from './components/NavBar'
import Home from './components/Home'
import About from './components/About'
import SignUp from './components/signup/SignUp'
import Admin from './components/Admin'
import { DataProvider } from './context/DataContext'

export default function App() {
  const [ showSearch, setShowSearch ] = React.useState(true)
  const [ tableData, setTableData ] = React.useState(null)
  const tableContext = { tableData: tableData, updateTable: (data) => { setTableData(data) } }

  React.useEffect(() => {
    setShowSearch(window.location.href.endsWith('/'))
  }, [window.location.href])

  return (
    <div className="App">
      <DataProvider value={tableContext}>
        <Router>
          <NavBar showSearch={showSearch} />
          <Switch>
              { /* Note: the html extension -- this is to avoid requiring SSR with Tomcat (i.e. each file is a COPY of the minified index.html file) */ }
            <Route exact path='/' component={Home} />
            <Route path='/about.html' component={About} />
            <Route path='/signup.html' component={SignUp} />
            <Route path='/admin.html' component={Admin} />
          </Switch>
        </Router>
      </DataProvider>
    </div>
  )
}