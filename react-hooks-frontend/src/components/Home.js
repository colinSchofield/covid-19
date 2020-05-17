import React from 'react'
import { getCovid19Daily } from '../utils/api'
import { Spinner, Alert } from 'react-bootstrap'
import Table from './Table'
import DataContext from '../context/DataContext'

export default function Home() {
  const [ data, setData ] = React.useState(null)
  const [ region, setRegion ] = React.useState(null)
  const [ error, setError ] = React.useState(null)
  const tableContext = React.useContext(DataContext)

  React.useEffect(() => {
    getCovid19Daily()
      .then((stats) => {
        setData(stats.response)
        tableContext.updateTable({data: stats.response, countrySelected: null})
      })
      .catch((exception) => {
        console.log("Error was Caught!", exception)
        setError(exception.message)
      })
  }, [])

  React.useEffect(() => {

    if (tableContext.tableData !== null &&
        tableContext.tableData.countrySelected !== null) {

      setRegion(tableContext.tableData.countrySelected)
    } else if (tableContext.tableData !== null &&
               tableContext.tableData.data !== null) {

      setData(tableContext.tableData.data)
    }
  }, [tableContext])

  return (

    <div>
      { error &&
        <Alert variant="danger">
        <Alert.Heading><span role="img" aria-labelledby="error">🛑</span> Error</Alert.Heading>
          <p>{error}</p>
        </Alert>
      }

      { !data && !error && <p><br/><br/><br/><br/></p> }
      { !data && !error && <Spinner animation="border" variant="success" /> }

      { data && <Table data={data} displayRegion={region} /> }
    </div>

  )
}