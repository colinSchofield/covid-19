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
     fullTable.current = tableContext.tableData
     searchFieldRef.current.disabled = false
     searchFieldRef.current.focus()
   }

  }, [ tableContext ])

  function filterTableBySearchField(event) {

    setSearchField(event.target.value)
    const filteredTable = fullTable.current.filter((element) =>
        element.country.toLowerCase().startsWith(event.target.value.toLowerCase()))

    tableContext.updateTable(filteredTable)
  }

  return (

    <Form inline>
      <FormControl type="text" disabled
        placeholder="Country Name" className="mr-sm-2"
        value={searchField} onChange={filterTableBySearchField} ref={searchFieldRef} />
      <Button variant="outline-success" onClick={() => {}}>Search</Button>
    </Form>
  )
}