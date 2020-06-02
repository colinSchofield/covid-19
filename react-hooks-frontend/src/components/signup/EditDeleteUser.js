import React from 'react'
import { MDBCard, MDBCardBody, MDBCardTitle, MDBCardText, MDBRow, MDBCol } from 'mdbreact'
import Image from 'react-bootstrap/Image'
import BannerImg from '../../assets/images/Coronavirus-Banner5.jpg'
import MapLayout from './MapLayout'
import Button from '@material-ui/core/Button'
import { MDBIcon, toast } from 'mdbreact'
import { Modal } from 'react-bootstrap'
import { useHistory } from "react-router-dom"
import { deleteUser } from '../../utils/api'
import { clearCookie } from '../../utils/cookies'


export default function EditDeleteUser({signupDetails, setActiveStep}) {
  const history = useHistory()
  const [showDialog, setShowDialog] = React.useState(false)
  const DETAILS_PAGE = 1

  const handleCloseDialog = () => setShowDialog(false)
  const handleShowDialog = () => setShowDialog(true)

  const handleDelete = () => {
    handleShowDialog()
  }

  const handleDeleteConfirm = () => {
    setShowDialog(false)

    deleteUser(signupDetails.id)
      .then((response) => {
        clearCookie()
        window.setTimeout(() => toast.success(<span><MDBIcon far icon="check-circle" /> Your Coronavirus details have been removed. </span>), 800)
        history.push("/")
      })
  }

  const handleEdit = () => {
    setActiveStep(DETAILS_PAGE)
  }

  return (
    <>
      <Modal show={showDialog} onHide={handleCloseDialog} animation={true}>
        <Modal.Header closeButton>
          <Modal.Title>Delete your Coronavirus details?</Modal.Title>
        </Modal.Header>
        <Modal.Body>We will be sad to see you go..</Modal.Body>
        <Modal.Footer>
          <Button variant="contained" onClick={handleCloseDialog}>
            Cancel
          </Button>
          <Button variant="contained" color="secondary" onClick={handleDeleteConfirm}>
            Delete
          </Button>
        </Modal.Footer>
      </Modal>

      <MDBRow className='align-middle'>
        <MDBCol md='4'>
        </MDBCol>
        <MDBCol md='4'>
          <MDBCard>
            <Image className="img-fluid" src={BannerImg} />
            <MDBCardBody>
              <MDBCardTitle>Your Information</MDBCardTitle>
              <MDBCardText>
              You may <b>Edit</b> or <b>Delete</b> your Coronavirus details:
              <br/>
              <br/>
              <table className="table table-striped table-hover table-bordered table-sm text-left">
                <tr>
                  <td className='font-weight-bold blue-text'>Name</td>
                  <td>{signupDetails.name}</td>
                </tr>
                <tr>
                  <td className='font-weight-bold blue-text'>Age</td>
                  <td>{signupDetails.age}</td>
                </tr>
                <tr>
                  <td className='font-weight-bold blue-text'>Gender</td>
                  <td>{signupDetails.gender}</td>
                </tr>

                { signupDetails.email !== '' && signupDetails.email !== null &&
                  <tr>
                    <td className='font-weight-bold blue-text'>Notification via Email</td>
                    <td>{signupDetails.email}</td>
                  </tr>
                }

                { signupDetails.sms !== '' && signupDetails.sms !== null &&
                  <tr>
                    <td className='font-weight-bold blue-text'>Notification via SMS</td>
                    <td>{signupDetails.sms}</td>
                  </tr>
                }
                <tr>
                  <td className='font-weight-bold blue-text'>Regions</td>
                  <td>
                    <MapLayout regions={signupDetails.regions} />
                  </td>
                </tr>
              </table>
              </MDBCardText>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
        <MDBCol md='4'>
        </MDBCol>
      </MDBRow>
      <br/>
      <div>
        <div>
          <Button variant="contained" color="primary" onClick={handleEdit}>Edit</Button>
          <Button variant="contained" color="secondary" onClick={handleDelete}>Delete</Button>
        </div>
      </div>
    </>
  )
}