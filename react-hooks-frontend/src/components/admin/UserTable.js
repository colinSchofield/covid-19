import React from 'react'
import BootstrapTable from 'react-bootstrap-table-next'

export default function UserTable({data}) {
  const userColumns = [
        {
          dataField: 'id',
          text: 'Id',
          hidden: true
        },
        {
          dataField: 'name',
          text: 'Name',
        },
        {
          dataField: 'age',
          text: 'Age',
        },
        {
          dataField: 'gender',
          text: 'Gender',
        },
        {
          dataField: 'contact',
          text: 'Contact',
        },
        {
          dataField: 'regionList',
          text: 'Regions',
        }
      ]
  const [detailsView, setDetailsView] = React.useState(false)


  const defaultSorted = [
    {
      dataField: 'age',
      order: 'desc'
    }
  ]

  const selectRow = {
    mode: 'radio',
    hideSelectColumn: true,
    clickToSelect: true,
    onSelect: (row, isSelect, rowIndex, e) => {
      // TODO Select a row for editing..
    }
  }

  return (
      <>
        <br/>
        <h4>Signed-Up Users</h4>
        <BootstrapTable
            selectRow={ selectRow }
            bootstrap4
            keyField="id"
            data={ data }
            columns={ userColumns }
            defaultSorted={ defaultSorted }
            striped
            hover
        />
      </>
    )
}