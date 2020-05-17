import React from 'react'
import { Button, Form, FormControl } from 'react-bootstrap'
import DataContext from '../context/DataContext'

export default function TableSearch() {
  const [ searchField, setSearchField ] = React.useState("")
  const fullTable = React.useRef(null)
  const searchFieldRef = React.useRef()
  const tableContext = React.useContext(DataContext)

  React.useEffect(() => {
   if (fullTable.current === null && tableContext.tableData !== null) {
     fullTable.current = tableContext.tableData.data
     searchFieldRef.current.disabled = false
     searchFieldRef.current.focus()
   }
  }, [ tableContext ])

  function filterTableBySearchField(event) {

    setSearchField(event.target.value)
    const filteredTable = fullTable.current.filter((element) =>
        element.country.toLowerCase().startsWith(event.target.value.toLowerCase()))

    tableContext.updateTable({data: filteredTable, countrySelected: null})
  }

  function handleSubmit(event) {
    event.preventDefault()

    if (tableContext.tableData.data.length > 0) {
      const country = tableContext.tableData.data[0].country
      tableContext.tableData.countrySelected = country
      tableContext.updateTable({data: tableContext.tableData.data, countrySelected: country})
    }
  }

  return (

    <Form onSubmit={handleSubmit} inline>
      <FormControl type="text" disabled
        placeholder="Country Name" className="mr-sm-2"
        value={searchField} onChange={filterTableBySearchField} ref={searchFieldRef} />
      <Button variant="outline-success" onClick={handleSubmit}>Search</Button>
    </Form>
  )
}