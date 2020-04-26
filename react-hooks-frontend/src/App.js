import React from 'react'
import './css/App.css'
import { getCovid19Stats } from './utils/api'
import Table from './components/Table'

export default function App() {
  const [ data, setData ] = React.useState(null)

  React.useEffect(() => {
    getCovid19Stats()
      .then((stats) => setData(stats.response))
      .catch((error) => {
        console.log("Error was Caught!", error)
        setData(error.message)
      })
  }, [])

  return (
    <div className="App">
      {
        (data === null) ?
        <strong>Loading...</strong>
          :
        <Table stats={data} />
      }
    </div>
  )
}