import React from 'react'
import { Line } from "react-chartjs-2";
import { MDBContainer } from "mdbreact";
import { Button, Modal } from 'react-bootstrap'

export default function TableDetails({dialogText}) {
  const [show, setShow] = React.useState(true);
  const [text, setText] = React.useState(dialogText)
  const [graphData, setGraphData] = React.useState(null)

  const handleClose = () => setShow(false);

  React.useEffect(() => {

    setText(dialogText)
    setShow(true)
  }, [dialogText])


  React.useEffect(() => {
    let dataChange = data
    dataChange.datasets[0].data = [120, 21, 5, 20, 5, 20, 0]
    setGraphData(dataChange)
  }, [])

  const data = {
      labels: ["Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"],
      datasets: [
        {
          label: "New Cases",
          fill: true,
          lineTension: 0.3,
          backgroundColor: "rgba(225, 204,230, .3)",
          borderColor: "rgb(205, 130, 158)",
          borderCapStyle: "butt",
          borderDash: [],
          borderDashOffset: 0.0,
          borderJoinStyle: "miter",
          pointBorderColor: "rgb(205, 130,1 58)",
          pointBackgroundColor: "rgb(255, 255, 255)",
          pointBorderWidth: 10,
          pointHoverRadius: 5,
          pointHoverBackgroundColor: "rgb(0, 0, 0)",
          pointHoverBorderColor: "rgba(220, 220, 220,1)",
          pointHoverBorderWidth: 2,
          pointRadius: 1,
          pointHitRadius: 10,
          data: [0, 0, 0, 0, 0, 0, 0]
        },
        {
          label: "Deaths",
          fill: true,
          lineTension: 0.3,
          backgroundColor: "rgba(184, 185, 210, .3)",
          borderColor: "rgb(35, 26, 136)",
          borderCapStyle: "butt",
          borderDash: [],
          borderDashOffset: 0.0,
          borderJoinStyle: "miter",
          pointBorderColor: "rgb(35, 26, 136)",
          pointBackgroundColor: "rgb(255, 255, 255)",
          pointBorderWidth: 10,
          pointHoverRadius: 5,
          pointHoverBackgroundColor: "rgb(0, 0, 0)",
          pointHoverBorderColor: "rgba(220, 220, 220, 1)",
          pointHoverBorderWidth: 2,
          pointRadius: 1,
          pointHitRadius: 10,
          data: [1, 3, 0, 5, 3, 2, 0]
        }
      ]
    }

  return (

    <div>
      <Modal show={show} onHide={handleClose} animation={false} size="lg" aria-labelledby="contained-modal-title-vcenter" centered>
        <Modal.Header closeButton>
          <Modal.Title id="contained-modal-title-vcenter"><strong>{text}</strong></Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <MDBContainer>
            <h4>New Cases and Deaths over the past week</h4>
            <br/><br/>
            <Line data={graphData} options={{ responsive: true }} />
          </MDBContainer>
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  )
}