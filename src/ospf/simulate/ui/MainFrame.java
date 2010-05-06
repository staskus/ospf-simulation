package ospf.simulate.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JSplitPane;

import ospf.simulate.ui.dialog.AddRouterDialog;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private MainFrame() {

		super();
		initialize();
	}

	private void initialize() {

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("OSPF路由协议模拟");
		this.setLocation(100, 100);
		this.setSize(800, 600);

		// TODO Add other components and containers
		this.setContentPane(getMainPane());
		this.setJMenuBar(getMainMenuBar());
	}

	public JSplitPane getMainPane() {

		if (mainSplitPane == null) {
			mainSplitPane = new JSplitPane();
			mainSplitPane.setLeftComponent(getLeftSplitPane());
			mainSplitPane.setRightComponent(getRightSplitPane());
		}
		return mainSplitPane;
	}

	public JSplitPane getLeftSplitPane() {

		if (leftSplitPane == null) {
			leftSplitPane = new JSplitPane();
			leftSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			leftSplitPane.setTopComponent(getRouterListPanel());
			leftSplitPane.setBottomComponent(getInterfaceListPanel());
		}
		return leftSplitPane;
	}

	public JSplitPane getRightSplitPane() {

		if (rightSplitPane == null) {
			rightSplitPane = new JSplitPane();
			rightSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		}
		return rightSplitPane;
	}

	public RouterListPanel getRouterListPanel() {

		if (routerListPanel == null) {
			routerListPanel = new RouterListPanel();
		}
		return routerListPanel;
	}

	public InterfaceListPanel getInterfaceListPanel() {

		if (interfaceListPanel == null) {
			interfaceListPanel = new InterfaceListPanel();
		}
		return interfaceListPanel;
	}

	public TopologyPanel getTopologyPanel() {

		if (topologyPanel == null) {
			topologyPanel = new TopologyPanel();
		}
		return topologyPanel;
	}

	// public RouterCLIPanel getRouterCLIPanel() {
	//		
	// if (routerCLIPanel == null) {
	// routerCLIPanel = new RouterCLIPanel();
	// }
	// return routerCLIPanel;
	// }

	public JMenuBar getMainMenuBar() {

		if (mainMenuBar == null) {
			mainMenuBar = new JMenuBar();

			mainMenuBar.add(getAddButton());
			mainMenuBar.add(getLinkButton());
			mainMenuBar.add(getRunButton());
		}
		return mainMenuBar;
	}

	public JButton getAddButton() {

		if (addButton == null) {
			addButton = new JButton("添加路由");
			addButton.setToolTipText("向模拟器中添加路由器");
			addButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 打开添加路由器的窗口，添加路由，并刷新RouterListPanel的界面
					AddRouterDialog dialog = new AddRouterDialog(MainFrame
							.getMainFrame());
					dialog.setVisible(true);
				}
			});
		}
		return addButton;
	}

	public JButton getLinkButton() {

		if (linkButton == null) {
			linkButton = new JButton("连线");
			linkButton.setToolTipText("连接路由器之间的线路");
			linkButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 打开连线的窗口

				}
			});
		}
		return linkButton;
	}

	public JButton getRunButton() {

		if (runButton == null) {
			runButton = new JButton("运行");
			runButton.setToolTipText("运行OSPF协议");
			runButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 运行OSPF协议，得到的结果存放在相应的数据库中

				}
			});
		}
		return runButton;
	}

	public static MainFrame getMainFrame() {

		if (mainFrame == null) {
			mainFrame = new MainFrame();
		}
		return mainFrame;
	}

	private JSplitPane mainSplitPane = null;
	private JSplitPane leftSplitPane = null;
	private JSplitPane rightSplitPane = null;
	private RouterListPanel routerListPanel = null;
	private InterfaceListPanel interfaceListPanel = null;
	private TopologyPanel topologyPanel = null;
	private RouterCLIPanel routerCLIPanel = null;

	private JMenuBar mainMenuBar = null;
	private JButton addButton = null;
	private JButton linkButton = null;
	private JButton runButton = null;
	private static MainFrame mainFrame = null;
}
