import React from 'react'
import BootstrapTable from 'react-bootstrap-table-next'
import paginationFactory from 'react-bootstrap-table2-paginator'
import TableDetails from './TableDetails'

export default function App({stats}) {
  const [detailsView, setDetailsView] = React.useState(false)
  const [dialogText, setDialogText] = React.useState("")

  const columns = [
    {
      dataField: 'country',
      text: 'Country',
      sort: true
    },
    {
      dataField: 'cases.total',
      text: 'Total Cases',
      sort: true
    },
    {
      dataField: 'cases.new',
      text: 'New Cases',
      sort: true
    },
    {
      dataField: 'deaths.total',
      text: 'Total Deaths',
      sort: true
    },
    {
      dataField: 'deaths.new',
      text: 'New Deaths',
      sort: true
    },
    {
      dataField: 'cases.recovered',
      text: 'Total Recovered',
      sort: true
    },
    {
      dataField: 'cases.active',
      text: 'Active Cases',
      sort: true
    },
    {
      dataField: 'cases.critical',
      text: 'Serious, Critical',
      sort: true
    },
    {
      dataField: 'tests.total',
      text: 'Total Tests',
      sort: true
    }
  ]

  const defaultSorted = [
    {
      dataField: 'deaths.total',
      order: 'desc'
    }
  ];

  const selectRow = {
    mode: 'radio',
    hideSelectColumn: true,
    clickToSelect: true,
    onSelect: (row, isSelect, rowIndex, e) => {
      setDialogText("🇦🇺 " + row.country + " 🇦🇺")
      setDetailsView(true)
    }
  }

  return (

      <div>
        <BootstrapTable
            selectRow={ selectRow }
            bootstrap4
            keyField="country"
            data={ stats }
            columns={ columns }
            defaultSorted={ defaultSorted }
            pagination={ paginationFactory() }
            striped
            hover
        />
        { detailsView && <TableDetails dialogText={dialogText} /> }
      </div>
    )
}