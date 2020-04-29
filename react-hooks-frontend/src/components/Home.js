import React from 'react'
import { getCovid19Stats } from '../utils/api'
import { Spinner } from 'react-bootstrap'
import { Alert } from 'react-bootstrap'
import Table from './Table'

export default function Home({ updateData, updateTable }) {
  const [ data, setData ] = React.useState(null)
  const [ error, setError ] = React.useState(null)
  const [ show, setShow ] = React.useState(true)

  React.useEffect(() => {
    if (updateData !== null) {
      setData(updateData)
    }
  }, [updateData])


  React.useEffect(() => {
    getCovid19Stats()
      .then((stats) => {
        updateTable(stats.response)
      })
      .catch((exception) => {
        console.log("Error was Caught!", exception)
        setError(exception.message)
      })
  }, [])

  return (

    <div>
      { (error !== null) &&
        <Alert variant="danger" onClose={() => setShow(false)}>
        <Alert.Heading>🛑 Error</Alert.Heading>
          <p>{error}</p>
        </Alert>
      }

      { data === null && error === null && <p><br/><br/><br/><br/></p> }
      { data === null && error === null && <Spinner animation="border" variant="success" /> }

      { data !== null && <Table stats={data} /> }
    </div>

  )
}