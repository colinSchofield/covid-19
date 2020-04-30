import React from 'react'
import { getCovid19Stats } from '../utils/api'
import { Spinner } from 'react-bootstrap'
import { Alert } from 'react-bootstrap'
import Table from './Table'
import DataContext from '../context/DataContext'

export default function Home() {
  const [ data, setData ] = React.useState(null)
  const [ error, setError ] = React.useState(null)
  const tableContext = React.useContext(DataContext)

  React.useEffect(() => {
    getCovid19Stats()
      .then((stats) => {
        setData(stats.response)
        tableContext.updateTable(stats.response)
      })
      .catch((exception) => {
        console.log("Error was Caught!", exception)
        setError(exception.message)
      })
  }, [])

  React.useEffect(() => {
      setData(tableContext.tableData)
  }, [tableContext])

  return (

    <div>
      { (error !== null) &&
        <Alert variant="danger">
        <Alert.Heading><span role="img" aria-labelledby="error">🛑</span> Error</Alert.Heading>
          <p>{error}</p>
        </Alert>
      }

      { data === null && error === null && <p><br/><br/><br/><br/></p> }
      { data === null && error === null && <Spinner animation="border" variant="success" /> }

      { data !== null && <Table stats={data} /> }
    </div>

  )
}